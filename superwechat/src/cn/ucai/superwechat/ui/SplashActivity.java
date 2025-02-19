package cn.ucai.superwechat.ui;

import android.content.Intent;
import android.os.Bundle;

import com.hyphenate.chat.EMClient;
import cn.ucai.superwechat.SuperWeChatHelper;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.utils.MFGT;

import com.hyphenate.util.EasyUtils;

/**
 * 开屏页
 *
 */
public class SplashActivity extends BaseActivity {

	private static final int sleepTime = 2000;

	@Override
	protected void onCreate(Bundle arg0) {
		setContentView(R.layout.em_activity_splash);
		super.onCreate(arg0);
	}

	@Override
	protected void onStart() {
		super.onStart();

		new Thread(new Runnable() {
			public void run() {
				if (SuperWeChatHelper.getInstance().isLoggedIn()) {
					// auto login mode, make sure all group and conversation is loaed before enter the main screen
					long start = System.currentTimeMillis();
					EMClient.getInstance().chatManager().loadAllConversations();
					EMClient.getInstance().groupManager().loadAllGroups();
					long costTime = System.currentTimeMillis() - start;
					//wait
					if (sleepTime - costTime > 0) {
						try {
							Thread.sleep(sleepTime - costTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					String topActivityName = EasyUtils.getTopActivityName(EMClient.getInstance().getContext());
					if (topActivityName != null && (topActivityName.equals(VideoCallActivity.class.getName()) || topActivityName.equals(VoiceCallActivity.class.getName()))) {
						// nop
						// avoid main screen overlap Calling Activity
					} else {
						//enter main screen
						startActivity(new Intent(SplashActivity.this, MainActivity.class));
					}
					finish();
				}else {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					}
					MFGT.gotoGuideActivity(SplashActivity.this);
					finish();
				}
			}
		}).start();

	}
	
	/**
	 * get sdk version
	 */
	private String getVersion() {
	    return EMClient.getInstance().VERSION;
	}
}
