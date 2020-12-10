package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int DEFAULT_FIRE_BULLETS = 10;

    public Rifle(String name, int bulletsCount) {
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
