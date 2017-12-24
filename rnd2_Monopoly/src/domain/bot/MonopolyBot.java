package domain.bot;

public  class MonopolyBot extends MonopolyBotObserver {

	public MonopolyBot() {
		this.emotion="Neutral";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(emotion);
	}
	
	public void setEmotion(String emo) {
		this.emotion=emo;
	}
	
	public String getEmotion() {
		return this.emotion;
	}

}
