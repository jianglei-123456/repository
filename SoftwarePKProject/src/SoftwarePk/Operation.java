package SoftwarePk;

public class Operation {
	private Info MailInfo;
	
	public void addRecord(String Name, String Number, String EMail){
		dao.Maillist ml = new dao.Maillist();
		dao.MaillistDAO mlDAO = new dao.MaillistDAO();
		ml.setName(Name);
		ml.setNumber(Number);
		ml.setEmail(EMail);
//		ml.setName("jiang");
//		ml.setNumber(0);
//		ml.setEmail("EMail");
		mlDAO.save(ml);
	}
	public void deleteRecord(int id){
		dao.MaillistDAO mlDAO = new dao.MaillistDAO();
		dao.Maillist ml = new dao.Maillist();
		ml = mlDAO.findById(id);
		mlDAO.delete(ml);
	}
	
	public void modifyRecord(int Id,String Name, String Number, String EMail){
		dao.MaillistDAO mlDAO = new dao.MaillistDAO();
		dao.Maillist ml = new dao.Maillist();
		ml = mlDAO.findById(Id);
		ml.setName(Name);
		System.out.print(Number);
		ml.setNumber(Number);
		ml.setEmail(EMail);
		mlDAO.save(ml);
	}
}
