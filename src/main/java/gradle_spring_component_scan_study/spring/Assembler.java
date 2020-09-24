package gradle_spring_component_scan_study.spring;
//package gradle_spring_autowired_study.spring;
//
//public class Assembler {
//
//	private MemberDao memberDao;
//	private MemberRegisterService regSvc;
//	private ChangePasswordService pwdSvc;
//	
//	
//
//	public Assembler() {
//		memberDao = new MemberDao();
//		regSvc = new MemberRegisterService(memberDao);
//		pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao);
//	}
//
//	public MemberDao getMemberDao() {
//		return memberDao;
//	}
//
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
//
//	public MemberRegisterService getRegSvc() {
//		return regSvc;
//	}
//
//	public void setRegSvc(MemberRegisterService regSvc) {
//		this.regSvc = regSvc;
//	}
//
//	public ChangePasswordService getPwdSvc() {
//		return pwdSvc;
//	}
//
//	public void setPwdSvc(ChangePasswordService pwdSvc) {
//		this.pwdSvc = pwdSvc;
//	}
////
//	public MemberRegisterService getMemberRegisterService() {
//		return regSvc;
//	}
//
//	public ChangePasswordService getChangePasswordService() {
//		return pwdSvc;
//	}
//
//}
