package dk.sdu.mmmi.cbse.enemysystem;

import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

@ServiceProviders(value = {
        @ServiceProvider(service = IGamePluginService.class), })
public class EnemyPlugin implements IGamePluginService {
    private Entity enemy;

    public EnemyPlugin() {
    }

    private Entity createEnemy(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 50;
        float maxSpeed = 150;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 8;
        float y = gameData.getDisplayHeight() - 20f;
        float radians = 3.1415f / 2;

        Entity enemy = new Enemy();
        enemy.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemy.add(new PositionPart(x, y, radians));

        return enemy;
    }

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        enemy = createEnemy(gameData);
        world.addEntity(enemy);

    }

    @Override
    public void stop(GameData gameData, World world) {
        // TODO Auto-generated method stub
        world.removeEntity(enemy);

    }
}
