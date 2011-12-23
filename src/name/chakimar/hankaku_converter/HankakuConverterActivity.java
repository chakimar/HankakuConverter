package name.chakimar.hankaku_converter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.widget.Toast;

public class HankakuConverterActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (cm.hasText()) {
        	CharSequence cs = cm.getText();
        	if (cs != null) {
        		String data = cs.toString();
				try {
					int num = Integer.parseInt(data);
	        		String convertData = String.valueOf(num);
	        		cm.setText(convertData);
	        		showMessage("変換に成功しました。");
				} catch (NumberFormatException e) {
					showMessage("数値以外の文字が含まれています。");
				}
        	}
        } else {
        	showMessage("クリップボードが空です");
        }
        finish();
        
    }
    
    void showMessage(String text) {
    	Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}