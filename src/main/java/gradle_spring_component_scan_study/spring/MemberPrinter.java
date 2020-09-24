package gradle_spring_component_scan_study.spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {			// 기본 생성자
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");		// 기본생성자에서 dateTimeFormatter의 값을 초기화 
	}

    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out.printf("회원 정보: 아이디=%s,이메일=%s, 이름=%s, 등록일=%tF%n", member.getId(), member.getEmail(),
                    member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf("회원 정보: 아이디=%s,이메일=%s, 이름=%s, 등록일=%s%n", member.getId(), member.getEmail(),
                    member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));

        }
    }

//    //required = false 사용
//	@Autowired (required = false)
//	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}

    //Optional 사용
	@Autowired
	public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatter) {
		if (dateTimeFormatter.isPresent()) {
			this.dateTimeFormatter = dateTimeFormatter.get();
		}else {
			this.dateTimeFormatter = null;
		}
	}
	
//	//@Nullable 사용
//    @Autowired
//	public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
}
