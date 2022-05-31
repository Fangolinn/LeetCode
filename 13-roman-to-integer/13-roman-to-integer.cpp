class Solution {
public:
    int romanToInt(std::string s) {
        std::string::iterator i = s.end() - 1;
        int sum = 0;
        
        for(int previous = 0; i > s.begin() - 1; --i){
            int current = romanValue(*i);
            
            if(previous > current){
                sum -= current;
            }else{
                sum += current;
            }
            
            previous = current;
        }
        
        return sum;
    }
    
private:
    int romanValue(char c){
        switch(c){
                case 'I':
                    return 1;
                    break;
                case 'V':
                    return 5;
                    break;
                case 'X':
                    return 10;
                    break;
                case 'L':
                    return 50;
                    break;
                case 'C':
                    return 100;
                    break;
                case 'D':
                    return 500;
                    break;
                case 'M':
                    return 1000;
                    break;
            default:
                return 0;
        }
    }
};