package pantz.enhanced_nature.common.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShapeUtils {

    public static VoxelShape rotateShape(VoxelShape shape, Direction baseDir, Direction targetDir) {
        if (baseDir == targetDir) {
            return shape;
        }
        VoxelShape[] result = new VoxelShape[]{Shapes.empty()};

        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
            double x1 = minX * 16, y1 = minY * 16, z1 = minZ * 16;
            double x2 = maxX * 16, y2 = maxY * 16, z2 = maxZ * 16;

            double fromX = Math.min(x1, x2), toX = Math.max(x1, x2);
            double fromY = Math.min(y1, y2), toY = Math.max(y1, y2);
            double fromZ = Math.min(z1, z2), toZ = Math.max(z1, z2);

            switch (targetDir) {
                case SOUTH -> result[0] = Shapes.or(result[0], Shapes.box((16 - toX) / 16D, fromY / 16D, (16 - toZ) / 16D, (16 - fromX) / 16D, toY / 16D, (16 - fromZ) / 16D));
                case WEST  -> result[0] = Shapes.or(result[0], Shapes.box(fromZ / 16D, fromY / 16D, (16 - toX) / 16D, toZ / 16D, toY / 16D, (16 - fromX) / 16D));
                case EAST  -> result[0] = Shapes.or(result[0], Shapes.box((16 - toZ) / 16D, fromY / 16D, fromX / 16D, (16 - fromZ) / 16D, toY / 16D, toX / 16D));
                case UP    -> result[0] = Shapes.or(result[0], Shapes.box(fromX / 16D, (16 - toZ) / 16D, fromY / 16D, toX / 16D, (16 - fromZ) / 16D, toY / 16D));
                case DOWN  -> result[0] = Shapes.or(result[0], Shapes.box(fromX / 16D, fromZ / 16D, (16 - toY) / 16D, toX / 16D, toZ / 16D, (16 - fromY) / 16D));
                default    -> result[0] = Shapes.or(result[0], Shapes.box(fromX / 16D, fromY / 16D, fromZ / 16D, toX / 16D, toY / 16D, toZ / 16D));
            }
        });
        return result[0];
    }

    private static VoxelShape rotateHorizontalShape(VoxelShape shape, Direction target) {
        if (target == Direction.NORTH) return shape;

        VoxelShape[] result = new VoxelShape[]{Shapes.empty()};

        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
            double x1 = minX * 16, y1 = minY * 16, z1 = minZ * 16;
            double x2 = maxX * 16, y2 = maxY * 16, z2 = maxZ * 16;

            double fromX = Math.min(x1, x2), toX = Math.max(x1, x2);
            double fromY = Math.min(y1, y2), toY = Math.max(y1, y2);
            double fromZ = Math.min(z1, z2), toZ = Math.max(z1, z2);

            switch (target) {
                case SOUTH -> result[0] = Shapes.or(result[0], Shapes.box((16 - toX) / 16D, fromY / 16D, (16 - toZ) / 16D, (16 - fromX) / 16D, toY / 16D, (16 - fromZ) / 16D));
                case WEST  -> result[0] = Shapes.or(result[0], Shapes.box(fromZ / 16D, fromY / 16D, (16 - toX) / 16D, toZ / 16D, toY / 16D, (16 - fromX) / 16D));
                case EAST  -> result[0] = Shapes.or(result[0], Shapes.box((16 - toZ) / 16D, fromY / 16D, fromX / 16D, (16 - fromZ) / 16D, toY / 16D, toX / 16D));
                default    -> result[0] = Shapes.or(result[0], Shapes.box(fromX / 16D, fromY / 16D, fromZ / 16D, toX / 16D, toY / 16D, toZ / 16D));
            }
        });

        return result[0];
    }

    public static VoxelShape rotateShape(VoxelShape shape, Direction targetDirection) {
        return rotateShape(shape, Direction.NORTH, targetDirection);
    }

    public static VoxelShape[] rotateShape(VoxelShape baseNorth, VoxelShape customDown, VoxelShape customUp) {
        VoxelShape[] shapes = new VoxelShape[6];

        for (Direction dir : Direction.values()) {
            switch (dir) {
                case DOWN -> shapes[dir.get3DDataValue()] = customDown;
                case UP   -> shapes[dir.get3DDataValue()] = customUp;
                default   -> shapes[dir.get3DDataValue()] = rotateHorizontalShape(baseNorth, dir);
            }
        }

        return shapes;
    }

    public static VoxelShape[] rotateShape(VoxelShape baseNorth) {
        VoxelShape[] shapes = new VoxelShape[6];
        for (Direction dir : Direction.values()) {
            shapes[dir.get3DDataValue()] = rotateHorizontalShape(baseNorth, dir);
        }
        return shapes;
    }
}
