package gradle_spring_component_scan_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_spring_component_scan_study.spring.ChangePasswordService;
import gradle_spring_component_scan_study.spring.MemberDao;
import gradle_spring_component_scan_study.spring.MemberInfoPrinter;
import gradle_spring_component_scan_study.spring.MemberListPrinter;
import gradle_spring_component_scan_study.spring.MemberPrinter;
import gradle_spring_component_scan_study.spring.MemberRegisterService;
import gradle_spring_component_scan_study.spring.MemberSummaryPrinter;
import gradle_spring_component_scan_study.spring.VersionPrinter;

@Configuration			//해당 클래스를 스프링 설정 클래스로 지정한다.
public class AppCtx {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	// 직접주입 하드코딩함
	@Bean
	public MemberRegisterService memberRegSvc() {
//		return new MemberRegisterService(memberDao());
		return new MemberRegisterService();
	}
	
	// @autowired 사용하여 자동주입 -> setter method 필요가없다
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao());		//자동주입되어 필요가없어요
		return pwdSvc;
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
//		return new MemberListPrinter(memberDao(), memberPrinter());
		return new MemberListPrinter();
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter1());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}

	@Bean
	  public MemberInfoPrinter infoPrinter() {
	      MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//	      infoPrinter.setMemberDao(memberDao());
//	      infoPrinter.setPrinter(memberPrinter());
	      return infoPrinter;
	}
}
