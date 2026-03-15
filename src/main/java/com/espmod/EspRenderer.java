package com.espmod;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexRendering;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.joml.Matrix4f;

public class EspRenderer {

    public static void drawBox(MatrixStack matrices, Camera camera, BlockPos pos,
                                float r, float g, float b) {
        try {
            MinecraftClient client = net.minecraft.client.MinecraftClient.getInstance();
            if (client.getBufferBuilders() == null) return;

            VertexConsumerProvider.Immediate immediate =
                    client.getBufferBuilders().getEntityVertexConsumers();

            double camX = camera.getPos().x;
            double camY = camera.getPos().y;
            double camZ = camera.getPos().z;

            matrices.push();
            matrices.translate(pos.getX() - camX, pos.getY() - camY, pos.getZ() - camZ);

            Box box = new Box(0, 0, 0, 1, 1, 1).expand(0.01);
            VertexRendering.drawOutlinedBox(matrices, immediate.getBuffer(RenderLayer.LINES),
                    box, r, g, b, 1.0f);

            immediate.draw(RenderLayer.LINES);
            matrices.pop();
        } catch (Exception ignored) {}
    }
}
