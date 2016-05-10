/**
 * Created by m on 5/9/16.
 */
public class AllElements {

    private int numberOfActionariInterese=5;

    private int numberOfActoriObiective=5;

    private int numberOfExtensii=2;

    private int numberOfScenariiPasi=2;

    private int numberOfScenariiUtilizare=2;




    public AllElements(){
        Descriere descriere=new Descriere();
        descriere.setPlaintext("textul descreierei");

        Domeniu domeniu=new Domeniu();
        domeniu.setPlaintext("textul domeniului");

        ActionarInteres[] actionarInteres=new ActionarInteres[numberOfActionariInterese];
        for(int i=0;i<numberOfActionariInterese;i++){
            actionarInteres[i]=new ActionarInteres();
            actionarInteres[i].setNumeActionar("actionar "+i);
            actionarInteres[i].setTextInteres("interes "+i);
        }

        ActionariInterese actionariInterese=new ActionariInterese();
        for(int i=0;i<numberOfActionariInterese;i++){
            actionariInterese.addActionariInterese(actionarInteres[i]);
        }

        ActorObiectiv[]actorObiectivs=new ActorObiectiv[numberOfActoriObiective];
        for(int i=0;i<numberOfActoriObiective;i++){
            actorObiectivs[i]=new ActorObiectiv();
            actorObiectivs[i].setNumeActor("actor "+i);
            actorObiectivs[i].setTextObiectiv("obiectiv "+i);
        }

        ActoriObiective actoriObiective=new ActoriObiective();
        for(int i=0;i<numberOfActoriObiective;i++){
            actoriObiective.addActoriObiective(actorObiectivs[i]);
        }




        ScenariuDeUtilizare[] scenariuDeUtilizares=new ScenariuDeUtilizare[numberOfScenariiUtilizare];
        for(int i=0;i<numberOfScenariiUtilizare;i++){
            scenariuDeUtilizares[i]=new ScenariuDeUtilizare();
            //scenariuDeUtilizares[i].setExtensii(extensii[i]);
            //scenariuDeUtilizares[i].setObiectivContext(obiectivContext[i]);
            //scenariuDeUtilizares[i].setScenariiPasi(scenariiPasi[i]);
        }

        ScenariiDeUtilizare scenariiDeUtilizare=new ScenariiDeUtilizare();
        for(int i=0;i<2;i++){
            scenariiDeUtilizare.setScenariiDeUtilizare(scenariuDeUtilizares[i]);
        }

        ModelFisaCerinte modelFisaCerinte=new ModelFisaCerinte(descriere,domeniu,actionariInterese,actoriObiective,scenariiDeUtilizare);
        modelFisaCerinte.makeXML();
    }
}
