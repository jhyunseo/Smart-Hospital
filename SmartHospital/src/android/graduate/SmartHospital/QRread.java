package android.graduate.SmartHospital;

import com.google.zxing.client.android.integration.IntentIntegrator;
import com.google.zxing.client.android.integration.IntentResult;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.net.Uri;
import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.TextView;

public class QRread extends Activity {
    /** Called when the activity is first created. */
	String qrtext; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrread);
//        Button button = (Button) findViewById(R.id.qrBt);
//        button.setOnClickListener(new OnClickListener()
//		{
//			@Override
//			public void onClick(View view)
//			{
				// QR코드/바코드 스캐너를 구동합니다.
				IntentIntegrator.initiateScan(QRread.this);
//			}
//		});
    }
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// QR코드/바코드를 스캔한 결과 값을 가져옵니다.
		boolean ff = false;
		
		IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
		qrtext = result.getContents();
		//TextView t = (TextView)findViewById(R.id.qrTxt);
		//t.setText(qrtext);
		if(result!=null){
			ff=true;
		}
		// 결과값 출력
		if(ff){
			new AlertDialog.Builder(this)
				.setTitle("QR Code Text")
				.setMessage(result.getContents() + " [" + result.getFormatName() + "]")
				.setPositiveButton("확인", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
					}
				})
				.show();
		}
//		if(ff){	//parsing 해서 주소 넘김
//			Intent aa = new Intent(Intent.ACTION_WEB_SEARCH);
//			aa.setData(Uri.parse("http://google.com"));	//인터넷 연결 테스트용
//			startActivity(aa);
//		}
	}
}