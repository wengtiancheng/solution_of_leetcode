#include <iostream>
#include <string>
#include <vector>

std::string solution(int n, std::string template_,
                     std::vector<std::string> titles) {
    std::string result;
    
    // 对每个标题进行判断
    for (int i = 0; i < n; i++) {
        bool isMatch = canMatch(template_, titles[i]);
        result += (isMatch ? "True" : "False");
        if (i < n - 1) result += ",";
    }
    
    return result;
}

// 辅助函数：判断字符串是否匹配模板
bool canMatch(const std::string& temp, const std::string& title) {
    int i = 0, j = 0;
    std::vector<std::pair<int, int>> wildcards;
    
    // 找出所有通配符的位置
    while (i < temp.length()) {
        if (temp[i] == '{') {
            int start = i;
            while (i < temp.length() && temp[i] != '}') i++;
            wildcards.push_back({start, i});
        }
        i++;
    }
    
    // 如果没有通配符，直接比较
    if (wildcards.empty()) {
        return temp == title;
    }
    
    // 检查每个通配符之间的固定字符串是否匹配
    i = 0; j = 0;
    for (const auto& w : wildcards) {
        // 检查通配符前的固定字符串
        while (i < w.first) {
            if (j >= title.length() || temp[i] != title[j]) {
                return false;
            }
            i++; j++;
        }
        
        // 跳过通配符
        i = w.second + 1;
        
        // 如果是最后一个通配符，找下一个固定字符串的位置
        if (&w == &wildcards.back()) {
            std::string suffix = temp.substr(i);
            if (suffix.empty()) {
                return true;
            }
            return title.length() >= j + suffix.length() &&
                   title.substr(title.length() - suffix.length()) == suffix;
        } else {
            // 找下一个固定字符串的位置
            std::string nextFixed;
            int nextStart = wildcards[&w - &wildcards.front() + 1].first;
            if (i < nextStart) {
                nextFixed = temp.substr(i, nextStart - i);
                size_t pos = title.find(nextFixed, j);
                if (pos == std::string::npos) {
                    return false;
                }
                j = pos;
            }
        }
    }
    
    return true;
}

int main() {
  //  You can add more test cases here
  std::vector<std::string> testTitles1 = {"adcdcefdfeffe", "adcdcefdfeff",
                                          "dcdcefdfeffe", "adcdcfe"};
  std::vector<std::string> testTitles2 = {
      "CLSomGhcQNvFuzENTAMLCqxBdj", "CLSomNvFuXTASzENTAMLCqxBdj",
      "CLSomFuXTASzExBdj",          "CLSoQNvFuMLCqxBdj",
      "SovFuXTASzENTAMLCq",         "mGhcQNvFuXTASzENTAMLCqx"};
  std::vector<std::string> testTitles3 = {"abcdefg", "abefg", "efg"};

  std::cout << (solution(4, "ad{xyz}cdc{y}f{x}e", testTitles1) ==
                "True,False,False,True")
            << std::endl;
  std::cout << (solution(6, "{xxx}h{cQ}N{vF}u{XTA}S{NTA}MLCq{yyy}",
                         testTitles2) == "False,False,False,False,False,True")
            << std::endl;
  std::cout << (solution(3, "a{bdc}efg", testTitles3) == "True,True,False")
            << std::endl;

  return 0;
}