package dk.sdu.mmmi.cbse.asteroid;

import static dk.sdu.mmmi.cbse.asteroid.AsteroidType.LARGE;

import java.util.Random;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
        @ServiceProvider(service = IGamePluginService.class), })
public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    public AsteroidPlugin() {
    }

    private Entity createAsteroid(GameData gameData) {
        Random r = new Random();

        float deacceleration = 10;
        float acceleration = 50;
        float maxSpeed = 100;
        float rotationSpeed = 0.55f;
        float x = gameData.getDisplayWidth() / r.nextFloat();
        float y = gameData.getDisplayHeight() / r.nextFloat();
        float radians = 3.1415f / 2;

        Entity asteroid = new Asteroid(LARGE);
        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroid.add(new PositionPart(x, y, radians));

        return asteroid;
    }

    @Override
    public void start(GameData gameData, World world) {
        // TODO Auto-generated method stub

        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);

    }

    @Override
    public void stop(GameData gameData, World world) {
        // TODO Auto-generated method stub
        world.removeEntity(asteroid);

    }
}
