package Player;

import Chapter.Chapter1.Scene.House.BedRoom;

public class comments {
    private String currentChapter;
    public comments(String currentChapter){
        this.currentChapter=currentChapter;
    }
    public void comments(Player player, BedRoom bedRoom){
        if(currentChapter=="Chapter1"){
            if(bedRoom.door==false && player.lastOption.equals("open the door")){
                System.out.println("I Should get the key for open the door...");
            }
        }
    }
}
