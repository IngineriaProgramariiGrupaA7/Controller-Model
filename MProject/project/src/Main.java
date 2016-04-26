/**
 * Created by m on 4/26/16.
 */
public class Main {

    public static void main(String args[]){
        Descriere descriere=new Descriere();
        descriere.setPlaintext("textul descreierei");

        Domeniu domeniu=new Domeniu();
        domeniu.setPlaintext("textul domeniului");

        ActionarInteres[] actionarInteres=new ActionarInteres[4];
        for(int i=0;i<4;i++){
            actionarInteres[i]=new ActionarInteres();
            actionarInteres[i].setNumeActionar("actionar "+i);
            actionarInteres[i].setTextInteres("interes "+i);
        }

        ActionariInterese actionariInterese=new ActionariInterese();
        for(int i=0;i<4;i++){
            actionariInterese.addActionariInterese(actionarInteres[i]);
        }

        ActorObiectiv[]actorObiectivs=new ActorObiectiv[4];
        for(int i=0;i<4;i++){
            actorObiectivs[i]=new ActorObiectiv();
            actorObiectivs[i].setNumeActor("actor "+i);
            actorObiectivs[i].setTextObiectiv("obiectiv "+i);
        }

        ActoriObiective actoriObiective=new ActoriObiective();
        for(int i=0;i<4;i++){
            actoriObiective.addActoriObiective(actorObiectivs[i]);
        }

        ModelFisaCerinte modelFisaCerinte=new ModelFisaCerinte(descriere,domeniu,actionariInterese,actoriObiective);
        modelFisaCerinte.makeXML();
    }
}
