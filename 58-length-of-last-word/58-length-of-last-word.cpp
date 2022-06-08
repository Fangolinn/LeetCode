
#include <string>

class Solution {
  public:
    int lengthOfLastWord(std::string s) {
        std::istringstream input(s);

        std::string word;

        while(input >> word);

        return word.size();
    }
};