import java.util.Random;

public class U1 extends Rocket {
    private double basicChanceOfLunchExplosion;
    private double basicChangeOfLandingCrash;

    public U1() {
        super();
        basicChanceOfLunchExplosion = 0.0;
        basicChangeOfLandingCrash = 0.0;
    }

    public U1(int cost, int weight, int weightMax, double basicChanceOfLunchExplosion, double basicChangeOfLandingCrash) {
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

        if (rn <= (basicChangeOfLandingCrash * ((double)getWeight()/getWeightMax()))) {
            return false;
        } else {
            return true;
        }
    }
}
