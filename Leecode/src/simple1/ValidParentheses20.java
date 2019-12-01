package simple1;


/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
*/
public class ValidParentheses20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sample="(([]){})";//样例"(([]){})"
		//Solution s = new Solution();
		boolean b=false;
	//	b=s.isValid(sample);
		System.out.println(b);
	}
	
}
//	检错原则 检测到错的返回false 否则返回true
/*
class Solution {
    public boolean isValid(String s) {
    	boolean lr=true;//	双判断
    	boolean lr1=true;
    	if(s.length()==0) { //	长度为0返回正确
    		return true; 
    	}
    	else if(s.length()%2!=0){ //	长度为奇数返回错误
    		return false;
    	}
    	char[] ch;
    	ch=s.toCharArray(); //	字符串拆分成单个字符
    	
    	//	由中间向外判断
    	int len2=(int)ch.length/2-1; //	数组中间位置的前一个index
    	int i=1;
    	int j=0;
    	while(i<=ch.length/2&&lr){
    		char Rmid=ch[len2+j]; //	先取出中间的左边字符 由里向外判断
        	char Lmid=ch[len2+i];//	取出中间的右边字符
        	char Lmid1=rg(Lmid);
        	if(Rmid!=Lmid1) {
        		lr=false;
        	}
        	j-=1;
        	i+=1;
    	}
        if(lr) { //	如果已经通过判断 直接return true
        	return true;
        }
        //	否则继续执行
        //	逐个判断
        int len1=0;
        while(len1<ch.length-1){
        	char rs=rg(ch[len1+1]);
        	if(ch[len1]!=rs) {
        		lr1=false;
        	}
        	len1+=2;
        }
        if(lr1) {
        	return true;
        }
        return false;        
    }   
    char rg(char s){
    	if(s=='(') {
    		return ')';
    	}
    	else if(s==')'){
    		return '(';
    	}
    	else if(s=='{') {
    		return '}';
    	}
    	else if(s=='}') {
    		return '{';
    	}
    	else if(s=='[') {
    		return ']';
    	}
    	else if(s==']') {
    		return '[';
    	}
		return s;
    }
}
*/

