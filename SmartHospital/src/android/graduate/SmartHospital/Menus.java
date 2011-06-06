package android.graduate.SmartHospital;


import android.app.Activity;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Menus extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menus);
        
        String name = "Test";
        String hname = "TestH";
        String iday = "39";
        
        String simpleinfo = name+"���덈뀞�섏꽭��n"+hname+" 蹂묒썝�낅땲��\n"+iday+"�쇱㎏ �낆썝以묒씠��땲��";
        
        //TextView���쒖떆�댁쨪 �댁슜
        TextView tv = (TextView)findViewById(R.id.simpleinfo);
        tv.setText(simpleinfo);
        
        
        findViewById(R.id.mystatbtn).setOnClickListener(myClickListener);
        findViewById(R.id.noticebtn).setOnClickListener(myClickListener);
        findViewById(R.id.requestbtn).setOnClickListener(myClickListener);
        findViewById(R.id.hospitalinfobtn).setOnClickListener(myClickListener);
        findViewById(R.id.qrreadbtn).setOnClickListener(myClickListener);
        findViewById(R.id.parentcallbtn).setOnClickListener(myClickListener);
        findViewById(R.id.emergencybtn).setOnClickListener(myClickListener);
        
    }
    
    Button.OnClickListener myClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent;
			String parentPN; //蹂댄샇���꾪솕踰덊샇
			/**媛�踰꾪듉蹂꾨줈 �댁빞���쇱쓣 梨꾩썙�ｋ뒗��
			 * 
			 */
			switch(v.getId()){
			case R.id.mystatbtn:
				intent = new Intent(Menus.this, Mystat.class);
				startActivity(intent);
				break;
			case R.id.noticebtn:
				intent = new Intent(Menus.this, Notice.class);
				startActivity(intent);
				break;
			case R.id.requestbtn:
				intent = new Intent(Menus.this, RequestTalk.class);
				startActivity(intent);
				break;
			case R.id.hospitalinfobtn:
				intent = new Intent(Menus.this, Hospitalinfo.class);
				startActivity(intent);
				break;
			case R.id.qrreadbtn:
				intent = new Intent(Menus.this, QRread.class);
				startActivity(intent);
				break;
			case R.id.parentcallbtn:
				parentPN = "01193699621";	//蹂댄샇���꾪솕踰덊샇 DB�먯꽌 媛�졇��빞 ��
				intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+parentPN));
				startActivity(intent);
				break;
			case R.id.emergencybtn:
				//蹂묒썝��湲닿툒肄�
				((Button)findViewById(R.id.emergencybtn)).setBackgroundColor(Color.GREEN);
				((Button)findViewById(R.id.emergencybtn)).setText("�좉퀬 �꾨즺");
				break;
			}
		}
	};
}