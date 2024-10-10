import java.io.*;
import java.util.*;

public class Main {

    static int width, height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        List<Dot> shops = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            shops.add(new Dot(dir, len));
        }

        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        Dot donggeun = new Dot(dir, len);

        int sum = 0;
        for (int i = 0; i < shops.size(); i++) {
            sum += getMinDistance(donggeun, shops.get(i));
        }

        System.out.println(sum);

    }

    static int getMinDistance(Dot donggeun, Dot shop) {
        int sum = 0;
        int total = (width + height) * 2;
        switch (donggeun.dir) {
            case 1: {
                if (shop.dir == 1) {
                    if (donggeun.len > shop.len) {
                        sum = donggeun.len - shop.len;
                    } else {
                        sum = shop.len - donggeun.len;
                    }
                } else if (shop.dir == 2) {
                    sum = height + donggeun.len + shop.len;
                } else if (shop.dir == 3) {
                    sum = donggeun.len + shop.len;
                } else if (shop.dir == 4) {
                    sum = width - donggeun.len + shop.len;
                }
                break;
            }

            case 2: {
                if (shop.dir == 1) {
                    sum = height + shop.len + donggeun.len;
                } else if (shop.dir == 2) {
                    if (donggeun.len > shop.len) {
                        sum = donggeun.len - shop.len;
                    } else {
                        sum = shop.len - donggeun.len;
                    }
                } else if (shop.dir == 3) {
                    sum = height - shop.len + donggeun.len;
                } else if (shop.dir == 4) {
                    sum = height - shop.len + width - donggeun.len;
                }
                break;
            }

            case 3: {
                if (shop.dir == 1) {
                    sum = height + shop.len + donggeun.len;
                } else if (shop.dir == 2) {
                    sum = height - donggeun.len + shop.len;
                } else if (shop.dir == 3) {
                    if (donggeun.len > shop.len) {
                        sum = donggeun.len - shop.len;
                    } else {
                        sum = shop.len - donggeun.len;
                    }
                } else if (shop.dir == 4) {
                    sum = width + shop.len + donggeun.len;
                }
                break;
            }

            case 4: {
                if (shop.dir == 1) {
                    sum = width - shop.len + donggeun.len;
                } else if (shop.dir == 2) {
                    sum = height - donggeun.len + width - shop.len;
                } else if (shop.dir == 3) {
                    sum = width + donggeun.len + shop.len;
                } else if (shop.dir == 4) {
                    if (donggeun.len > shop.len) {
                        sum = donggeun.len - shop.len;
                    } else {
                        sum = shop.len - donggeun.len;
                    }
                }
                break;
            }
        }
        return Math.min(sum, total - sum);
    }

    static class Dot {
        int dir;
        int len;

        public Dot(int dir, int len) {
            this.dir = dir;
            this.len = len;
        }
    }

}