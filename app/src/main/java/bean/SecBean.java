package bean;

import java.util.List;

/**
 * Created by pheng on 2016/5/9.
 */
public class SecBean {

    /**
     * comment : 10
     * tags : [{"id":1,"name":"搞笑"},{"id":55,"name":"微视频"},{"id":248,"name":"囧事"}]
     * bookmark : 10
     * text : 印尼某地居民将充气娃娃当天使供拜，不禁想起了那年的“肉灵芝”
     * up : 380
     * share_url : http://c.f.winapp111.com.cn/share/18393870.html?wx.qq.com
     * down : 92
     * forward : 19
     * u : {"header":["http://wimg.spriteapp.cn/profile/profile/20150730102114.jpg","http://dimg.spriteapp.cn/profile/profile/20150730102114.jpg"],"is_v":false,"uid":"15405038","is_vip":false,"name":"暴走大事件"}
     * passtime : 2016-05-09 09:26:01
     * video : {"playfcount":2279,"height":480,"width":852,"video":["http://bvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpd.mp4","http://wvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpd.mp4","http://dvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpd.mp4"],"duration":172,"playcount":6399,"thumbnail":["http://wimg.spriteapp.cn/picture/2016/0507/572d59ff947a2_94.jpg","http://dimg.spriteapp.cn/picture/2016/0507/572d59ff947a2_94.jpg"],"download":["http://bvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpc.mp4","http://wvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpc.mp4","http://dvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpc.mp4"]}
     * type : video
     * id : 18393870
     */
    private InfoBean info;

    private List<ListBean> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class InfoBean {
        private int count;
        private double np;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getNp() {
            return np;
        }

        public void setNp(double np) {
            this.np = np;
        }
    }

    public static class ListBean {
        private String comment;
        private String bookmark;
        private String text;
        private String up;
        private String share_url;
        private int down;
        private String forward;
        /**
         * header : ["http://wimg.spriteapp.cn/profile/profile/20150730102114.jpg","http://dimg.spriteapp.cn/profile/profile/20150730102114.jpg"]
         * is_v : false
         * uid : 15405038
         * is_vip : false
         * name : 暴走大事件
         */

        private UBean u;
        private String passtime;
        /**
         * playfcount : 2279
         * height : 480
         * width : 852
         * video : ["http://bvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpd.mp4","http://wvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpd.mp4","http://dvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpd.mp4"]
         * duration : 172
         * playcount : 6399
         * thumbnail : ["http://wimg.spriteapp.cn/picture/2016/0507/572d59ff947a2_94.jpg","http://dimg.spriteapp.cn/picture/2016/0507/572d59ff947a2_94.jpg"]
         * download : ["http://bvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpc.mp4","http://wvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpc.mp4","http://dvideo.spriteapp.cn/video/2016/0507/572d5a0003781_wpc.mp4"]
         */

        private VideoBean video;
        private String type;
        private String id;

        private GifBean gif;

        private ImageBean image;



        /**
         * id : 1
         * name : 搞笑
         */

        private List<TagsBean> tags;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public UBean getU() {
            return u;
        }

        public void setU(UBean u) {
            this.u = u;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public Page paging;

        public GifBean getGif() {
            return gif;
        }

        public void setGif(GifBean gif) {
            this.gif = gif;
        }

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public class Page {
            public String next_url;
        }

        public static class UBean {
            private boolean is_v;
            private String uid;
            private boolean is_vip;
            private String name;
            private List<String> header;

            public boolean isIs_v() {
                return is_v;
            }

            public void setIs_v(boolean is_v) {
                this.is_v = is_v;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getHeader() {
                return header;
            }

            public void setHeader(List<String> header) {
                this.header = header;
            }
        }

        public static class VideoBean {
            private int playfcount;
            private int height;
            private int width;
            private int duration;
            private int playcount;
            private List<String> video;
            private List<String> thumbnail;
            private List<String> download;

            public int getPlayfcount() {
                return playfcount;
            }

            public void setPlayfcount(int playfcount) {
                this.playfcount = playfcount;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public List<String> getVideo() {
                return video;
            }

            public void setVideo(List<String> video) {
                this.video = video;
            }

            public List<String> getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(List<String> thumbnail) {
                this.thumbnail = thumbnail;
            }

            public List<String> getDownload() {
                return download;
            }

            public void setDownload(List<String> download) {
                this.download = download;
            }
        }

        public static class GifBean {
            private List<String> images;
            private int width;
            private List<String> gif_thumbnail;
            private List<String> download_url;
            private int height;


            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<String> getGif_thumbnail() {
                return gif_thumbnail;
            }

            public void setGif_thumbnail(List<String> gif_thumbnail) {
                this.gif_thumbnail = gif_thumbnail;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }

        }

        public static class ImageBean {
            private List<String> big;
            private List<String> download_url;
            private int height;
            private int width;
            private List<String> small;

            public List<String> getBig() {
                return big;
            }

            public void setBig(List<String> big) {
                this.big = big;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<String> getSmall() {
                return small;
            }

            public void setSmall(List<String> small) {
                this.small = small;
            }

        }


        public static class TagsBean {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
