package q3;

public class TaskStatus {
	private int completedCnt = 0; // �Ϸ�� �۾� �� 
	private int unCompletedCnt = 0; // �Ϸ���� ���� �۾� �� 
	
	public int getCompletedCnt() {
		return completedCnt;
	}
	
	public int getUnCompletedCnt() {
		return unCompletedCnt;
	}
	
	public void incrementCompeted() {
		completedCnt++;
	}
	
	public void incrementUnCompleted() {
		unCompletedCnt++;
	}
}
