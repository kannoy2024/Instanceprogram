package work3;

import java.util.Stack;

class Test {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String dir : stack) {
            stringBuilder.append("/").append(dir);
        }

        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }
}
