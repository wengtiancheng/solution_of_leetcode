class lc100422 {
    //复习，分隔字符串的方法，将字符转化为整数的方法，，将整数转化为二进制的方法这些都是API
    public String convertDateToBinary(String date) {
        // 分割字符串，得到年、月、日
        String[] parts = date.split("-");

        // 将年、月、日分别转换为整数
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // 将年、月、日分别转换为二进制字符串
        String binaryYear = Integer.toBinaryString(year);
        String binaryMonth = Integer.toBinaryString(month);
        String binaryDay = Integer.toBinaryString(day);

        // 按照格式返回结果
        return binaryYear + "-" + binaryMonth + "-" + binaryDay;
    }

}