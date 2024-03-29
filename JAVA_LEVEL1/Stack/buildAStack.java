package PEP.JAVA_LEVEL1.Stack;


import java.io.*;

public class buildAStack {

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            // write ur code here
            return tos + 1;
        }

        void display() {
            // write ur code here
            for (int i = tos; i >= 0; i--)
                System.out.print(data[i] + " ");
            System.out.println();

        }

        void push(int val) {
            // write ur code here
            if (tos == data.length - 1) {
                System.out.println("Stack overflow");
            } else {
                tos++;
                data[tos] = val;
            }
        }

        int pop() throws IOException {
            // write ur code here
            if (tos != -1) {
                int val = data[tos];
                tos--;
                return val;
            } else {
                System.out.println("Stack Underflow");
                return -1;
            }
        }

            int top() {
                // write ur code here
                if (tos != -1) {
                    return data[tos];
                } else {
                    System.out.println("Stack Underflow");
                    return -1;
                }
            }
        }



            public static void main (String[] args) throws Exception {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.parseInt(br.readLine());
                CustomStack st = new CustomStack(n);

                String str = br.readLine();
                while (!str.equals("quit")) {
                    if (str.startsWith("push")) {
                        int val = Integer.parseInt(str.split(" ")[1]);
                        st.push(val);
                    } else if (str.startsWith("pop")) {
                        int val = st.pop();
                        if (val != -1) {
                            System.out.println(val);
                        }
                    } else if (str.startsWith("top")) {
                        int val = st.top();
                        if (val != -1) {
                            System.out.println(val);
                        }
                    } else if (str.startsWith("size")) {
                        System.out.println(st.size());
                    } else if (str.startsWith("display")) {
                        st.display();
                    }
                    str = br.readLine();
                }
            }

}