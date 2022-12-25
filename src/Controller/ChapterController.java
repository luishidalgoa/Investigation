package Controller;
import Player.*;
import Chapter.Chapter1.*;

public class ChapterController {
    static String currentChapter;
    private Player player;

    public ChapterController(){
        this.player=new Player("BedRoom");
        ChapterFlow();
    }
    public void ChapterFlow(){
        currentChapter="Chapter one";
        Chapter1 chapter1=new Chapter1();
        chapter1.flowChapter(this.player);
        System.out.println("END");
    }
}
