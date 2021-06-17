package q3;

public class TaskStatus {
	private int completedCnt = 0; // 완료된 작업 수 
	private int unCompletedCnt = 0; // 완료되지 않은 작업 수 
	
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
