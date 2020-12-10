package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int DEFAULT_FIRE_BULLETS = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (this.getBulletsCount() < DEFAULT_FIRE_BULLETS) {
            return 0;
        }
        this.setBulletsCount(this.getBulletsCount() - DEFAULT_FIRE_BULLETS);
        return DEFAULT_FIRE_BULLETS;
    }
}
