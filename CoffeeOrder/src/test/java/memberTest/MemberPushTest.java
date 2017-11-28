package memberTest;

import java.io.IOException;

import kr.kosta.coffeeorder.dao.MemberDao;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class MemberPushTest {

	public final static String APIKey = "AIzaSyCBbz3fOBDGe8WaWnuW28on2oKARa0NG-k";
	@Autowired
	private MemberService memberService;

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		MemberDao dao = ctx.getBean(MemberDao.class);
		Member member = dao.selectMember("01091205923");

		Sender sender = new Sender(MemberPushTest.APIKey); // 구글 코드에서 발급받은 서버 키
		Message msg = new Message.Builder()
				.addData("id", String.valueOf(member.getId()))
				.addData("name", member.getName()).build();

		// 푸시 전송. 파라미터는 푸시 내용, 보낼 단말의 id, 마지막은 잘 모르겠음
		Result result;
		try {
			result = sender.send(msg, member.getDeviceId(), 5);

			// 결과 처리
			if (result.getMessageId() != null) {
				// 푸시 전송 성공
			} else {
				String error = result.getErrorCodeName(); // 에러 내용 받기

				// 에러 처리
				if (Constants.ERROR_INTERNAL_SERVER_ERROR.equals(error)) {
					// 구글 푸시 서버 에러
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
