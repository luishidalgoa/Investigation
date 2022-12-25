package Chapter.Chapter1;

import Chapter.Chapter1.Scene.House.BedRoom;
import Chapter.Chapter1.Scene.House.LivingRoom;
import Controller.ControlOptions;
import Player.Player;
import Utils.*;

public class Chapter1 {
    private final BedRoom bedRoom;
    private final LivingRoom livingRoom;

    public Chapter1() {
        this.bedRoom = new BedRoom();
        this.livingRoom = new LivingRoom();
    }

    public void flowChapter(Player player) {
        player.setCurrentScene("BedRoom");
        boolean end;
        do {
            end = false;
            optionScene(player);
        } while (!end);
    }

    public void optionScene(Player player) { //NO FUNCIONAN LAS OPCIONES DE ESCENARIO. IMPLEMENTAR ARRAYLIST
        String[] options;
        if (player.getCurrentScene().equals("BedRoom")) {
            options = bedRoom.getOptionsItems();
            int c=options.length-1;
            for(int i=0;i<bedRoom.getMoveToScene().length;i++){
                options[c]+=bedRoom.moveTo(i);
                c++;
            }
            Menu.showMenu(options);
        } else if (player.getCurrentScene().equals("LivingRoom")) {
            options = livingRoom.getOptionsItems();
            for(int i=options.length;i<livingRoom.moveTo().length;i++){
                options[i]+=livingRoom.moveTo();
            }
            Menu.showMenu(options);
        }
        ControlOptions.ControlOptions();
    }
}
