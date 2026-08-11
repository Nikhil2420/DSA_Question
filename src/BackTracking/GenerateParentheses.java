package BackTracking;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses {

    ArrayList<String> ans;
    public ArrayList<String> generateParentheses(int n) {
        StringBuilder sb=new StringBuilder();
        ans=new ArrayList<>();
        solve(sb,n);
        return ans;
    }
    public void solve(StringBuilder sb,int n){

        if(sb.length()==n){
            String res=sb.toString();
            if(isValid(res)){
                ans.add(res);
                return;
            }
            return;
        }
        //take
        sb.append("(");
        solve(sb,n);
        sb.deleteCharAt(sb.length()-1);//notTake
        sb.append(")");//take
        solve(sb,n);
        sb.deleteCharAt(sb.length()-1);//notTake
    }

    public boolean isValid(String str){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(')stack.push(ch);
            else{
                if(stack.isEmpty() || stack.peek()!='(')return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}