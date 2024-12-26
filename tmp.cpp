#include <iostream>
#include <map>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <sstream>
using namespace std;

class Player{
    public:
        string character_id;
        int base_strength;
        int base_mana;
        int base_agility;
        int level;
        int strength;
        int mana;
        int agility;
        string equipment;
        
        Player(string id) : character_id(id), level(1), base_strength(0), base_mana(0), base_agility(0),equipment(""), strength(0), mana(0), agility(0) {}
        
        virtual ~Player() {}
        
        virtual void set_attribute(const string& attribute, int value) {
            if(attribute == "base_strength"){
                base_strength = value;
            }else if(attribute == "base_mana"){
                base_mana = value;
            }else if(attribute == "base_agility"){
                base_agility = value;
            }
        }
        
        virtual bool equip(string type, int value){
            if(!equipment.empty()){
                cout << "Character " << character_id << " already has equipment" << endl;
                return false;
            }
            
            if(can_equip(type)){
                equipment = type;
                apply_equip(value);
                return true;
            }
            
            cout << "this equipment does not suit" << endl;
            return false;
        }
        
        virtual void upgrade(){
            if(level >= 5){
                cout << "Character " << character_id << " is already at max level" << endl;
            }else{
                level++;
                increase_attributes();
                
            }
        }
        
        virtual void increase_attributes() = 0;

        virtual int get_strength() = 0;
        virtual int get_mana() = 0;
        virtual int get_agility() = 0;
          
        
        virtual double get_power() = 0;
        
    protected:
    
        virtual bool can_equip(const string& type) = 0;
        virtual void apply_equip(int value) = 0;
        
    
        
};

class Warrior : public Player
{
    public:
        int weapon_strength;
        Warrior(string id) : Player(id), weapon_strength(0) {}
         
        
        void upgrade() override {
            if(level >= 5){
                cout << "Character " << character_id << " is already at max level" << endl;
            }else{
                level++;
                increase_attributes();
                
            }
            
        }
        
        double get_power() override {
            return (base_strength + weapon_strength) * 1.5 + base_mana * 0.5 + base_agility * 0.8;
        }
        
        void increase_attributes() override {
            base_strength *= 1.1;
        }

        int get_strength() override{
            return base_strength + weapon_strength;
        }
        int get_mana() override{
            return base_mana;
        }
        int get_agility() override{
            return base_agility;
        }
        
    protected:
         bool can_equip(const string& type){
             return (type == "weapon");
         }
        void apply_equip(int value){
            weapon_strength = value;
        }
        
};

class Mage : public Player
{
    public:
        int staff_power;
        Mage(string id) : Player(id), staff_power(0) {}
        
        void upgrade() override{
            if(level >= 5){
                cout << "Character " << character_id << " is already at max level" << endl;
            }else{
                level++;
                increase_attributes();
                
            }
            
        }
        
        double get_power() override{
            return base_strength * 0.6 + (base_mana + 2 * staff_power) * 2.0 + base_agility * 0.7;
        }
        
        void increase_attributes() override{
            base_mana *= 1.2;
        }

        int get_strength() override{
            return base_strength;
        }
        int get_mana() override{
            return base_mana + 2 * staff_power;
        }
        int get_agility() override{
            return base_agility;
        }
        
    protected:
         virtual bool can_equip(const string& type){
             return (type == "staff");
         }
        virtual void apply_equip(int value){
            staff_power = value;
        }
        
};
class Rogue : public Player
{
    public:
        int stealth_bonus;
        Rogue(string id) : Player(id), stealth_bonus(0){}
        
        void upgrade() override{
            if(level >= 5){
                cout << "Character " << character_id << " is already at max level" << endl;
            }else{
                level++;
                increase_attributes();
                
            }
            
        }
        
        double get_power() override{
            return base_strength * 0.6 + base_mana * 0.4 + (base_agility + stealth_bonus) * 1.8;
        }
        
        void increase_attributes() override{
            base_mana *= 1.15;
        }

        int get_strength() override{
            return base_strength;
        }
        int get_mana() override{
            return base_mana;
        }
        int get_agility() override{
            return base_agility + stealth_bonus;
        }
        
    protected:
         virtual bool can_equip(const string& type){
             return (type == "cloak");
         }
        virtual void apply_equip(int value){
            stealth_bonus = value;
        }
        
};



class System{
    public:
        map<string, Player*> players;
        map<string, vector<string>> teams;
        
        
        void add(string role, string id){
            if(role == "Warrior"){
                players[id] = new Warrior(id);
            }else if(role == "Mage"){
                players[id] = new Mage(id);
            }else if(role == "Rogue"){
                players[id] = new Rogue(id);
            }
        }
        
        void set(string id, string attribute, int value){
            if(players.find(id) != players.end()){
                players[id]->set_attribute(attribute, value);
            }
        }

        void add_team(string team_id, vector<string> player_ids){
            teams[team_id] = player_ids;
        }
        
        void adjust_team(string team_id, string attribute, int value){
            if(teams.find(team_id) != teams.end()){
                for(auto& id : teams[team_id]){
                    if(players.find(id) != players.end()){
                        players[id]->set_attribute(attribute, value);
                    }
                }
            }
        }
        
        
         //按照名字的升序输出角色的所有属性
        void list_normal(){
            vector<string> names;
            for(auto& pair : players){
                names.push_back(pair.first);
            }
            
            sort(names.begin(), names.end());
            
            for(auto& name : names){
                cout << name << " ";
                cout << "strength " << players[name]->get_strength() << " ";
                cout << "mana " << players[name]->get_mana() << " ";
                cout << "agility " << players[name]->get_agility() << endl;
                
            }
           
    

        }
        //Power ：按角色的综合战力降序输出角色的全部属性，若战力相同则按名字升序输出
        void list_power(){
            vector<pair<string, double>> powers;
            for(auto& pair : players){
                powers.push_back({pair.first, pair.second->get_power()});
            }
            
            sort(powers.begin(), powers.end(), [](const pair<string, double>& a, const pair<string, double>&b){
                if(a.second == b.second){
                    return a.first < b.first;
                }
                return a.second > b.second;
                
            });
            
            for(auto& p :powers){
                cout << p.first << " ";
                cout << "strength " << players[p.first]->get_strength() << " ";
                cout << "mana " << players[p.first]->get_mana() << " ";
                cout << "agility " << players[p.first]->get_agility() << endl;
                
            }
            
        }
        
        void upgrade(string id){
            if(players.find(id) != players.end()){
                players[id]->upgrade();
            }
        }
        void equip(string id, string type, int value){
            if(players.find(id) != players.end()){
                players[id]->equip(type, value);
            }
        }
        
        void powerlist(){
            vector<pair<string, double>> powers;
            for(auto& pair : players){
                powers.push_back({pair.first, pair.second->get_power()});
            }
            
            sort(powers.begin(), powers.end(), [](const pair<string, double>& a, const pair<string, double>&b){
                return a.first < b.first;
                
            });
            
            for(auto& p :powers){
                cout << p.first << " power: " << p.second << endl;
            }
            
        }
        
        void battle(string id1, string id2){
             if(players.find(id1) != players.end() && players.find(id2) != players.end()){
                double power1 = players[id1]->get_power();
                double power2 = players[id2]->get_power();

                if (fabs(power1 - power2) < 0.1 * min(power1, power2)) {
                    cout << "Draw" << endl;
                } else if (power1 > power2) {
                    cout << id1 << " wins" << endl;
                } else {
                    cout << id2 << " wins" << endl;
                }
                
                
            }
        }
        
};

int main(){
    int n;
    cin >> n;
    System sys;
    for(int i = 0; i < n; i++){
        string action;
        cin >> action;
        if (action == "Add") {
            string role, id;
            cin >> role >> id;
            sys.add(role, id);
        }else if (action == "Set") {
            string id, attribute;
            int value;
            cin >> id >> attribute >> value;
            sys.set(id, attribute, value);
        }else if(action == "Team"){
            string team_id;
            
            cin >> team_id;
            vector<string> player_ids;
            string line;
            getline(cin, line);
            stringstream ss(line);
            string id;
            while(ss >> id){
                player_ids.push_back(id);
            }
            sys.add_team(team_id, player_ids);
        }else if(action == "Modify"){
            string team_id, attribute;
            int value;
            cin >> team_id >> attribute >> value;
            sys.adjust_team(team_id, attribute, value);
        }else if(action == "List"){
            string type;
            cin >> type;
            if(type == "Normal"){
                sys.list_normal();
            }else if(type == "Power"){
                sys.list_power();
            }
        }else if(action == "Upgrade"){
            string id;
            cin >> id;
            sys.upgrade(id);
        }else if(action == "Equip"){
            string id, type;
            int value;
            cin >> id >> type >> value;
            sys.equip(id, type, value);
        }else if(action == "PowerList"){
            sys.powerlist();
        }else if(action == "Battle"){
            string id1, id2;
            cin >> id1 >> id2;
            sys.battle(id1, id2);
        }else{
            cout << "Invalid action" << endl;
        }
    }
    return 0;
}