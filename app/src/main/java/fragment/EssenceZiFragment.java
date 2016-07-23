package fragment;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.sun.budejie.CommendActivity;
import com.sun.budejie.R;

import java.util.ArrayList;
import java.util.List;

import bean.SecBean;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import utils.MyGsonTask;
import utils.MyRoundTran;

/**
 * Created by Y.vn on 2016/5/6.
 */
public class EssenceZiFragment extends Fragment{
    RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    List<SecBean.ListBean> list=new ArrayList<>();
    private String url;
    private MyAdapter adapter;
    private boolean isLoadMore=false;
    private LinearLayoutManager mManager;
    private MediaController mController;
    
    public void setUrl(String url){
        this.url=url;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.essence_zi_fragment,container,false);
        initRecyclerView(view);
        initGsonTask();
        initReflesh();
        initLoadMore();
        return view;
    }

    private void initGsonTask() {
        new MyGsonTask<SecBean>(new MyGsonTask.DoBackListener<SecBean>() {
           @Override
           public void onBack(SecBean bean) {
               if (isLoadMore) {
                   //加载更多的逻辑
                   list.addAll(bean.getList());
                   adapter.notifyDataSetChanged();
               } else {
                   list.clear();
                   //刷新的逻辑
                   list=bean.getList();
                   adapter.notifyDataSetChanged();
                   //取消刷新按钮
                   mSwipeRefreshWidget.setRefreshing(false);
                   Toast toast = Toast.makeText(getActivity(), "刷新完成，共有"+bean.getInfo().getCount()+"条数据", Toast.LENGTH_SHORT);
                   toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 100);
                   toast.show();
               }
               Log.i("3333","4444"+bean.getList());
           }
       }, SecBean.class).execute(url);
    }

    private void initRecyclerView(View view) {
        mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        mManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mManager);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        initReflesh();
        initLoadMore();

        adapter=new MyAdapter();
        mRecyclerView.setAdapter(adapter);
    }

    private void initReflesh() {
        mSwipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Log.i("12345", "刷新运行了");
                initGsonTask();

            }
        });
    }

    private void initLoadMore() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //判断到底有没有到最后一条
                //如果到最后一条数据的话，请求网络加载数据
                //获得最后一条可见条目的位置
                int lastVisibleItemPosition = mManager.findLastVisibleItemPosition();
                int itemCount = mManager.getItemCount();
              /*  if (RecyclerView.SCROLL_STATE_DRAGGING==newState){
                    mController.hide();
                }*/
                if (((lastVisibleItemPosition + 1) == itemCount) && RecyclerView.SCROLL_STATE_IDLE == newState) {

                        initGsonTask();
                }
            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private static final int TYPE_VIDEO = 0;
        private static final int TYPE_IMAGE = 1;
        private static final int TYPE_GIF = 2;
        private static final int TYPE_TEXT = 3;
        @Override
        public int getItemViewType(int position) {
            if (list.get(position).getType().equals("video")) {
                return TYPE_VIDEO;
            } else if(list.get(position).getType().equals("image")) {
                return TYPE_IMAGE;
            } else if(list.get(position).getType().equals("gif")){
                return TYPE_GIF;
            }else{
                return TYPE_TEXT;
            }
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case TYPE_VIDEO:
                    View viewVideo = LayoutInflater.from(getActivity()).inflate(R.layout.essence__zi_video_item,parent,false);
                    return new VideoHolder(viewVideo);
                case TYPE_IMAGE:
                    View viewImage = LayoutInflater.from(getActivity()).inflate(R.layout.essence_zi_image_item,parent,false);
                    return new ImageHolder(viewImage);
                case TYPE_TEXT:
                    View viewText = LayoutInflater.from(getActivity()).inflate(R.layout.essence_zi_text_item,parent,false);
                    return new TextHolder(viewText);
                case TYPE_GIF:
                    View viewGif=LayoutInflater.from(getActivity()).inflate(R.layout.essence_zi_gif_item,parent,false);
                    return new GifImageHolder(viewGif);
            }
            //can't reach
            return null;
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            int viewType = getItemViewType(position);
            switch (viewType) {
                case TYPE_VIDEO:
                    final VideoHolder holder1= (VideoHolder) holder;
                    holder1.mVideoView.setVideoPath(list.get(position).getVideo().getVideo().get(0));
                    Log.i("===", "网址准备好" + list.get(position).getVideo().getVideo().get(0));
                    mController=new MediaController(getActivity());
                    if(!holder1.mVideoView.isFocused()){
                        holder1.mVideoView.resume();
                        holder1.mImageButton.setVisibility(View.VISIBLE);
                        holder1.iv_video.setVisibility(View.VISIBLE);
                        mController.hide();
                    }
                    if ((list.get(position).getVideo().getDuration() % 60) < 10) {
                        holder1.tv5.setText(list.get(position).getVideo().getDuration() / 60 + " : 0" + list.get(position).getVideo().getDuration() % 60);
                        holder1.tv5.setTextColor(Color.WHITE);
                    } else {
                        holder1.tv5.setText(list.get(position).getVideo().getDuration() / 60 + " : " + list.get(position).getVideo().getDuration() % 60);
                        holder1.tv5.setTextColor(Color.WHITE);
                    }
                    holder1.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            holder1.iv_video.setVisibility(View.VISIBLE);
                            Log.i("mtag", "准备好了");
                            holder1.mImageButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.i("mtag", "播放键被点击了");
                                    holder1.mImageButton.setVisibility(View.GONE);
                                    holder1.mVideoView.requestFocus();
                                    holder1.mVideoView.start();
                                    holder1.iv_video.setVisibility(View.GONE);
                                    holder1.mVideoView.setMediaController(mController);
                                }
                            });

                        }
                    });

                    holder1.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            holder1.mVideoView.stopPlayback();
                            holder1.mImageButton.setVisibility(View.VISIBLE);
                            holder1.iv_video.setVisibility(View.VISIBLE);
                        }
                    });

                    initListener(position, holder1);

                    Picasso.with(getActivity()).load(list.get(position).getVideo().getThumbnail().get(0)).placeholder(R.mipmap.ic_launcher).into(holder1.iv_video);
                    Picasso.with(getActivity()).load(list.get(position).getU().getHeader().get(0)).transform(new MyRoundTran())
                            .resize(70, 70).centerCrop().placeholder(R.mipmap.ic_launcher).into(holder1.iv);
                    holder1.tv1.setText(list.get(position).getU().getName());
                    holder1.tv2.setText(list.get(position).getPasstime());
                    holder1.tv3.setText(list.get(position).getText());
                    holder1.tv4.setText(list.get(position).getVideo().getPlaycount() + "" + "次播放");
                    holder1.tv4.setTextColor(Color.WHITE);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < list.get(position).getTags().size(); i++) {
                        sb.append(list.get(position).getTags().get(i).getName() + "  ");
                    }
                    holder1.tv6.setText(sb.toString());
                    holder1.tv9.setText(list.get(position).getUp());
                    holder1.tv10.setText(list.get(position).getDown() + "");
                    holder1.tv11.setText(list.get(position).getForward());
                    holder1.tv12.setText(list.get(position).getComment());
                    break;

                case TYPE_IMAGE:
                    final ImageHolder holder2 = (ImageHolder) holder;

                    initListener(position, holder2);

                    Picasso.with(getActivity()).load(list.get(position).getU().getHeader().get(0)).transform(new MyRoundTran())
                            .resize(70, 70).centerCrop().placeholder(R.mipmap.ic_launcher).into(holder2.iv1);
                    Picasso.with(getActivity()).load(list.get(position).getImage().getBig().get(0)).placeholder(R.mipmap.ic_launcher).into(holder2.iv2);
                    holder2.tv1.setText(list.get(position).getU().getName());
                    holder2.tv2.setText(list.get(position).getPasstime());
                    holder2.tv3.setText(list.get(position).getText());
                    StringBuilder sb1 = new StringBuilder();
                    for (int i = 0; i < list.get(position).getTags().size(); i++) {
                        sb1.append(list.get(position).getTags().get(i).getName() + "  ");
                    }
                    holder2.tv4.setText(sb1.toString());
                    holder2.tv7.setText(list.get(position).getUp());
                    holder2.tv8.setText(list.get(position).getDown() + "");
                    holder2.tv9.setText(list.get(position).getForward());
                    holder2.tv10.setText(list.get(position).getComment());

                    break;
                case TYPE_TEXT:
                    final TextHolder holder3 = (TextHolder) holder;
                    initListener(position, holder3);

                    Picasso.with(getActivity()).load(list.get(position).getU().getHeader().get(0)).transform(new MyRoundTran())
                            .resize(70, 70).centerCrop().placeholder(R.mipmap.ic_launcher).into(holder3.iv1);
                    holder3.tv1.setText(list.get(position).getU().getName());
                    holder3.tv2.setText(list.get(position).getPasstime());
                    holder3.tv3.setText(list.get(position).getText());
                    StringBuilder sb2 = new StringBuilder();
                    for (int i = 0; i < list.get(position).getTags().size(); i++) {
                        sb2.append(list.get(position).getTags().get(i).getName() + "  ");
                    }
                    holder3.tv4.setText(sb2.toString());
                    holder3.tv7.setText(list.get(position).getUp());
                    holder3.tv8.setText(list.get(position).getDown() + "");
                    holder3.tv9.setText(list.get(position).getForward());
                    holder3.tv10.setText(list.get(position).getComment());
                    break;

                case TYPE_GIF:
                    final GifImageHolder holder4 = (GifImageHolder) holder;
                    initListener(position, holder4);

                    Picasso.with(getActivity()).load(list.get(position).getU().getHeader().get(0)).transform(new MyRoundTran())
                            .resize(70, 70).centerCrop().placeholder(R.mipmap.ic_launcher).into(holder4.iv1);
                    Glide.with(getActivity()).load(list.get(position).getGif().getImages().get(0)).placeholder(R.mipmap.ic_launcher).into(holder4.iv2);
                    holder4.tv1.setText(list.get(position).getU().getName());
                    holder4.tv2.setText(list.get(position).getPasstime());
                    holder4.tv3.setText(list.get(position).getText());
                    StringBuilder sb3 = new StringBuilder();
                    for (int i = 0; i < list.get(position).getTags().size(); i++) {
                        sb3.append(list.get(position).getTags().get(i).getName() + "  ");
                    }
                    holder4.tv4.setText(sb3.toString());
                    holder4.tv7.setText(list.get(position).getUp());
                    holder4.tv8.setText(list.get(position).getDown() + "");
                    holder4.tv9.setText(list.get(position).getForward());
                    holder4.tv10.setText(list.get(position).getComment());
                    break;
            }
        }

        private void initListener(final int position, final VideoHolder holder) {
            holder.ib1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib2.setEnabled(false);
                    holder.ib1.setImageResource(R.mipmap.ding_has_clicked);
                    int count1 = Integer.parseInt(list.get(position).getUp());
                    holder.tv9.setText(count1 + 1 + "");
                    holder.tv9.setTextColor(Color.RED);
                }
            });

            holder.ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib1.setEnabled(false);
                    holder.ib2.setImageResource(R.mipmap.cai_has_clicked);
                    int count2=list.get(position).getDown();
                    holder.tv10.setText(count2+1+"");
                    holder.tv10.setTextColor(Color.RED);
                }

            });

            holder.ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initShareSdk();
                }
            });

            holder.ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(),CommendActivity.class));
                }
            });
        }

        private void initListener(final int position, final ImageHolder holder) {
            holder.ib1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib2.setEnabled(false);
                    holder.ib1.setImageResource(R.mipmap.ding_has_clicked);
                    int count1 = Integer.parseInt(list.get(position).getUp());
                    holder.tv7.setText(count1 + 1 + "");
                    holder.tv7.setTextColor(Color.RED);
                }
            });

            holder.ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib1.setEnabled(false);
                    holder.ib2.setImageResource(R.mipmap.cai_has_clicked);
                    int count2=list.get(position).getDown();
                    holder.tv8.setText(count2+1+"");
                    holder.tv8.setTextColor(Color.RED);
                }

            });

            holder.ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initShareSdk();
                }
            });

            holder.ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(),CommendActivity.class));
                }
            });
        }

        private void initListener(final int position, final GifImageHolder holder) {
            holder.ib1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib2.setEnabled(false);
                    holder.ib1.setImageResource(R.mipmap.ding_has_clicked);
                    int count1 = Integer.parseInt(list.get(position).getUp());
                    holder.tv7.setText(count1 + 1 + "");
                    holder.tv7.setTextColor(Color.RED);
                }
            });

            holder.ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib1.setEnabled(false);
                    holder.ib2.setImageResource(R.mipmap.cai_has_clicked);
                    int count2=list.get(position).getDown();
                    holder.tv8.setText(count2+1+"");
                    holder.tv8.setTextColor(Color.RED);
                }

            });

            holder.ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initShareSdk();
                }
            });

            holder.ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(),CommendActivity.class));
                }
            });
        }

        private void initListener(final int position, final TextHolder holder) {
            holder.ib1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib2.setEnabled(false);
                    holder.ib1.setImageResource(R.mipmap.ding_has_clicked);
                    int count1 = Integer.parseInt(list.get(position).getUp());
                    holder.tv7.setText(count1 + 1 + "");
                    holder.tv7.setTextColor(Color.RED);
                }
            });

            holder.ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.ib1.setEnabled(false);
                    holder.ib2.setImageResource(R.mipmap.cai_has_clicked);
                    int count2=list.get(position).getDown();
                    holder.tv8.setText(count2+1+"");
                    holder.tv8.setTextColor(Color.RED);
                }

            });

            holder.ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initShareSdk();
                }
            });

            holder.ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(),CommendActivity.class));
                }
            });
        }

        private void initShareSdk() {
            ShareSDK.initSDK(getActivity());
            OnekeyShare oks = new OnekeyShare();
            //关闭sso授权
            oks.disableSSOWhenAuthorize();

            // title标题：微信、QQ（新浪微博不需要标题）
            oks.setTitle("我是分享标题");  //最多30个字符

            // text是分享文本：所有平台都需要这个字段
            oks.setText("我是分享文本，啦啦啦~http://uestcbmi.com/");  //最多40个字符

            // imagePath是图片的本地路径：除Linked-In以外的平台都支持此参数
            //oks.setImagePath(Environment.getExternalStorageDirectory() + "/meinv.jpg");//确保SDcard下面存在此张图片

            //网络图片的url：所有平台
            oks.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul

            // url：仅在微信（包括好友和朋友圈）中使用
            oks.setUrl("http://sharesdk.cn");   //网友点进链接后，可以看到分享的详情

            // Url：仅在QQ空间使用
            oks.setTitleUrl("http://www.baidu.com");  //网友点进链接后，可以看到分享的详情

            // 启动分享GUI
            oks.show(getActivity());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class VideoHolder extends RecyclerView.ViewHolder{
            boolean flag=false;
            ImageButton mImageButton;
            ImageButton ib3;
            ImageButton ib1;
            ImageButton ib2;
            ImageButton ib4;
            ImageView iv;
            ImageView iv_video;
            TextView tv1;
            TextView tv2;
            TextView tv3;
            TextView tv4;
            TextView tv5;
            TextView tv6;
            TextView tv9;
            TextView tv10;
            TextView tv11;
            TextView tv12;
            VideoView mVideoView;
            public VideoHolder(View itemView) {
                super(itemView);
                 mVideoView= (VideoView) itemView.findViewById(R.id.videoview);
                 mImageButton= (ImageButton) itemView.findViewById(R.id.videoImageButton);
                ib1= (ImageButton) itemView.findViewById(R.id.iv3);
                ib2= (ImageButton) itemView.findViewById(R.id.iv4);
                ib3= (ImageButton) itemView.findViewById(R.id.iv5);
                ib4= (ImageButton) itemView.findViewById(R.id.iv6);
                iv_video= (ImageView) itemView.findViewById(R.id.image_video);
                iv= (ImageView) itemView.findViewById(R.id.iv1);
                tv1= (TextView) itemView.findViewById(R.id.tv1);
                tv2= (TextView) itemView.findViewById(R.id.tv2);
                tv3= (TextView) itemView.findViewById(R.id.tv3);
                tv4= (TextView) itemView.findViewById(R.id.tv4);
                tv5= (TextView) itemView.findViewById(R.id.tv5);
                tv6= (TextView) itemView.findViewById(R.id.tv6);
                tv9= (TextView) itemView.findViewById(R.id.tv9);
                tv10= (TextView) itemView.findViewById(R.id.tv10);
                tv11= (TextView) itemView.findViewById(R.id.tv11);
                tv12= (TextView) itemView.findViewById(R.id.tv12);

            }
        }
        class ImageHolder extends RecyclerView.ViewHolder{
            ImageView iv1;
            ImageView iv2;
            ImageButton ib3;
            ImageButton ib1;
            ImageButton ib2;
            ImageButton ib4;
            TextView tv1;
            TextView tv2;
            TextView tv3;
            TextView tv4;
            TextView tv7;
            TextView tv8;
            TextView tv9;
            TextView tv10;
            public ImageHolder(View itemView) {
                super(itemView);
                iv1= (ImageView) itemView.findViewById(R.id.iv1_img);
                iv2= (ImageView) itemView.findViewById(R.id.utilImage);
                ib1= (ImageButton) itemView.findViewById(R.id.iv3_img);
                ib2= (ImageButton) itemView.findViewById(R.id.iv4_img);
                ib3= (ImageButton) itemView.findViewById(R.id.iv5_img);
                ib4= (ImageButton) itemView.findViewById(R.id.iv6_img);
                tv1= (TextView) itemView.findViewById(R.id.tv1_img);
                tv2= (TextView) itemView.findViewById(R.id.tv2_img);
                tv3= (TextView) itemView.findViewById(R.id.tv3_img);
                tv4= (TextView) itemView.findViewById(R.id.tv4_img);
                tv7= (TextView) itemView.findViewById(R.id.tv7_img);
                tv8= (TextView) itemView.findViewById(R.id.tv8_img);
                tv9= (TextView) itemView.findViewById(R.id.tv9_img);
                tv10= (TextView) itemView.findViewById(R.id.tv10_img);

            }
        }
        class TextHolder extends RecyclerView.ViewHolder{
            ImageView iv1;
            ImageButton ib3;
            ImageButton ib1;
            ImageButton ib2;
            ImageButton ib4;
            TextView tv1;
            TextView tv2;
            TextView tv3;
            TextView tv4;
            TextView tv7;
            TextView tv8;
            TextView tv9;
            TextView tv10;
            public TextHolder(View itemView) {
                super(itemView);

                iv1= (ImageView) itemView.findViewById(R.id.iv1_text);
                ib1= (ImageButton) itemView.findViewById(R.id.iv3_text);
                ib2= (ImageButton) itemView.findViewById(R.id.iv4_text);
                ib3= (ImageButton) itemView.findViewById(R.id.iv5_text);
                ib4= (ImageButton) itemView.findViewById(R.id.iv6_text);
                tv1= (TextView) itemView.findViewById(R.id.tv1_text);
                tv2= (TextView) itemView.findViewById(R.id.tv2_text);
                tv3= (TextView) itemView.findViewById(R.id.tv3_text);
                tv4= (TextView) itemView.findViewById(R.id.tv4_text);
                tv7= (TextView) itemView.findViewById(R.id.tv7_text);
                tv8= (TextView) itemView.findViewById(R.id.tv8_text);
                tv9= (TextView) itemView.findViewById(R.id.tv9_text);
                tv10= (TextView) itemView.findViewById(R.id.tv10_text);
            }
        }
        class GifImageHolder extends RecyclerView.ViewHolder{
            ImageView iv1;
            ImageView iv2;
            ImageButton ib3;
            ImageButton ib1;
            ImageButton ib2;
            ImageButton ib4;
            TextView tv1;
            TextView tv2;
            TextView tv3;
            TextView tv4;
            TextView tv7;
            TextView tv8;
            TextView tv9;
            TextView tv10;
            public GifImageHolder(View itemView) {
                super(itemView);
                iv1= (ImageView) itemView.findViewById(R.id.iv1_gif);
                iv2= (ImageView) itemView.findViewById(R.id.gifImageView);
                ib1= (ImageButton) itemView.findViewById(R.id.iv3_gif);
                ib2= (ImageButton) itemView.findViewById(R.id.iv4_gif);
                ib3= (ImageButton) itemView.findViewById(R.id.iv5_gif);
                ib4= (ImageButton) itemView.findViewById(R.id.iv6_gif);
                tv1= (TextView) itemView.findViewById(R.id.tv1_gif);
                tv2= (TextView) itemView.findViewById(R.id.tv2_gif);
                tv3= (TextView) itemView.findViewById(R.id.tv3_gif);
                tv4= (TextView) itemView.findViewById(R.id.tv4_gif);
                tv7= (TextView) itemView.findViewById(R.id.tv7_gif);
                tv8= (TextView) itemView.findViewById(R.id.tv8_gif);
                tv9= (TextView) itemView.findViewById(R.id.tv9_gif);
                tv10= (TextView) itemView.findViewById(R.id.tv10_gif);
            }
        }
    }
}
