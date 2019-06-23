import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class U2 extends Rocket {
    private double basicChanceOfLunchExplosion;
    private double basicChangeOfLandingCrash;

    public U2() {
        super();
        basicChanceOfLunchExplosion = 0.0;
        basicChangeOfLandingCrash = 0.0;
    }

    public U2(int cost, int weight, int weightMax, double basicChanceOfLunchExplosion, double basicChangeOfLandingCrash) {
        super(cost, weight, weightMax);
        this.basicChanceOfLunchExplosion = basicChanceOfLunchExplosion;
        this.basicChangeOfLandingCrash = basicChangeOfLandingCrash;
    }

    public void setBasicChanceOfLunchExplosion(double basicChanceOfLunchExplosion) {
        this.basicChanceOfLunchExplosion = basicChanceOfLunchExplosion;
    }

    public void setBasicChangeOfLandingCrash(double basicChangeOfLandingCrash) {
        this.basicChangeOfLandingCrash = basicChangeOfLandingCrash;
    }

    @Override
    public boolean launch() {
        Random rg = new Random();
        double rn = rg.nextDouble();

        if (rn <= (basicChanceOfLunchExplosion * ((double)getWeight()/getWeightMax()) )) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean land() {
        Random rg = new Random();
        double rn = rg.nextDouble();
        double prob = basicChangeOfLandingCrash * ((double)getWeight()/getWeightMax());
        if (rn <= prob) {
            return false;
        } else {
            return true;
        }
    }
}
