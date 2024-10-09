package org.sckj.grid_list.utils;

public class RandomData {

    public static String[] getData() {
        int x = (int) (Math.random() * 11);
        if (x < 2)
            x += 2;
        String[] ranData = new String[x];
        String[] data = new String[]{
                "https://img0.baidu.com/it/u=726659053,3382276044&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=313"
                , "https://img2.baidu.com/it/u=2566230917,2808117782&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500"
                , "https://img2.baidu.com/it/u=3163476269,1000606524&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500"
                , "https://img2.baidu.com/it/u=3328039940,1634058035&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800"
                , "https://img2.baidu.com/it/u=910253571,2017645416&fm=253&fmt=auto&app=138&f=JPEG?w=281&h=500"
                , "https://img1.baidu.com/it/u=2837652998,4021252017&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=675"
                , "https://img0.baidu.com/it/u=2717356261,1786359072&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=313"
                , "https://img0.baidu.com/it/u=1171594143,1875442752&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=281"
                , "https://img1.baidu.com/it/u=2618826375,1078087229&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800"
                , "https://img1.baidu.com/it/u=2488103991,1511047245&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500"
                , "https://img0.baidu.com/it/u=4228699106,1691303226&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=889"
                , "https://img2.baidu.com/it/u=1446691496,425368337&fm=253&fmt=auto&app=120&f=JPEG?w=486&h=864"
                , "https://img0.baidu.com/it/u=2578411517,695534278&fm=253&fmt=auto&app=120&f=JPEG?w=690&h=319"
                , "https://img1.baidu.com/it/u=3372864782,1962540369&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=667"
                , "https://img0.baidu.com/it/u=1280262366,3826370161&fm=253&fmt=auto&app=120&f=JPEG?w=690&h=460"
                , "https://img2.baidu.com/it/u=3748805054,2087677140&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=505"
                , "https://img2.baidu.com/it/u=2663748359,1556611389&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=667"
                , "https://img0.baidu.com/it/u=2604966659,2171290114&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=533"
                , "https://img2.baidu.com/it/u=2231038979,2691613695&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=545"
                , "https://img2.baidu.com/it/u=961128276,3705358938&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=748"
                , "https://img1.baidu.com/it/u=2463820807,2327784832&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=700"
                , "https://img1.baidu.com/it/u=3031161111,2503110494&fm=253&fmt=auto&app=120&f=JPEG?w=498&h=664"
                , "https://img1.baidu.com/it/u=204230593,4263131619&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=889"
                , "https://img0.baidu.com/it/u=2546074984,3127704902&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=667"
                , "https://img2.baidu.com/it/u=168907843,205033263&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=667"
                , "https://img2.baidu.com/it/u=2926250603,2659619180&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=688"
                , "https://img0.baidu.com/it/u=1628198855,850895292&fm=253&fmt=auto&app=120&f=JPEG?w=667&h=500"
                , "https://img1.baidu.com/it/u=3396705277,795050562&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=625"
                , "https://img2.baidu.com/it/u=3086533199,1335310252&fm=253&fmt=auto&app=120&f=JPEG?w=480&h=853"
                , "https://img2.baidu.com/it/u=1173758272,2959311201&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=667"
                , "https://img0.baidu.com/it/u=3078918626,3951434079&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=747"
                , "https://img1.baidu.com/it/u=3947817616,193742124&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=701"
                , "https://img1.baidu.com/it/u=1415429778,67167048&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=723"
                , "https://img2.baidu.com/it/u=3797347625,2483589189&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=737"
                , "https://img0.baidu.com/it/u=3365640836,629021495&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=727"
                , "https://img1.baidu.com/it/u=1694170302,3391096319&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=810"
        };
        try {
            for (int j = 0; j < ranData.length; j++) {
                int i = (int) (Math.random() * 36);
                ranData[j] = data[i];
            }
        } catch (Exception ignored) {

        }
        return ranData;
    }
}
