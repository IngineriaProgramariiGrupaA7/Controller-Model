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

        ObiectivContext []obiectivContext=new ObiectivContext[2];
        for(int i=0;i<2;i++){
            obiectivContext[i]=new ObiectivContext();
            obiectivContext[i].setObiectivContext("obiectiv"+i);
        }



        ScenariuPasi[]scenariuPasi=new ScenariuPasi[2];
        for(int i=0;i<2;i++){
            scenariuPasi[i]=new ScenariuPasi();
            scenariuPasi[i].setScenariuPasi("scenariu"+i);
        }

        ScenariiPasi[]scenariiPasi=new ScenariiPasi[2];
        for(int i=0;i<2;i++){
            scenariiPasi[i]=new ScenariiPasi();
            scenariiPasi[i].addScenariuPasi(scenariuPasi[i]);
        }


        Extensie[]extensie=new Extensie[2];
        for(int i=0;i<2;i++){
            extensie[i]=new Extensie();
            extensie[i].setExtensie("extensie"+i);
        }

        Extensii []extensii=new Extensii[2];
        for(int i=0;i<2;i++){
            extensii[i]=new Extensii();
            extensii[i].addExtensii(extensie[i]);
        }


        ScenariuDeUtilizare[] scenariuDeUtilizares=new ScenariuDeUtilizare[numberOfScenariiUtilizare];
        for(int i=0;i<numberOfScenariiUtilizare;i++){
            scenariuDeUtilizares[i]=new ScenariuDeUtilizare();
            scenariuDeUtilizares[i].setExtensii(extensii[i]);
            scenariuDeUtilizares[i].setObiectivContext(obiectivContext[i]);
            scenariuDeUtilizares[i].setScenariiPasi(scenariiPasi[i]);
        }

        ScenariiDeUtilizare[] scenariiDeUtilizare=new ScenariiDeUtilizare[2];
        for(int i=0;i<2;i++){
            scenariiDeUtilizare[i]=new ScenariiDeUtilizare();
            scenariiDeUtilizare[i].setScenariiDeUtilizare(scenariuDeUtilizares[i]);
        }

        ModelFisaCerinte modelFisaCerinte=new ModelFisaCerinte(descriere,domeniu,actionariInterese,actoriObiective);
        modelFisaCerinte.makeXML();
    }
}
