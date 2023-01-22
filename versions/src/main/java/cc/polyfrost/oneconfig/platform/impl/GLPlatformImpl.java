/*
 * This file is part of OneConfig.
 * OneConfig - Next Generation Config Library for Minecraft: Java Edition
 * Copyright (C) 2021~2023 Polyfrost.
 *   <https://polyfrost.cc> <https://github.com/Polyfrost/>
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 *   OneConfig is licensed under the terms of version 3 of the GNU Lesser
 * General Public License as published by the Free Software Foundation, AND
 * under the Additional Terms Applicable to OneConfig, as published by Polyfrost,
 * either version 1.0 of the Additional Terms, or (at your option) any later
 * version.
 *
 *   This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 * License.  If not, see <https://www.gnu.org/licenses/>. You should
 * have also received a copy of the Additional Terms Applicable
 * to OneConfig, as published by Polyfrost. If not, see
 * <https://polyfrost.cc/legal/oneconfig/additional-terms>
 */

package cc.polyfrost.oneconfig.platform.impl;

import cc.polyfrost.oneconfig.libs.universal.UMatrixStack;
import cc.polyfrost.oneconfig.libs.universal.UMinecraft;
import cc.polyfrost.oneconfig.platform.GLPlatform;

//#if FORGE==1
import net.minecraft.client.shader.Framebuffer;
//#else
//$$ import cc.polyfrost.oneconfig.internal.hook.FramebufferHook;
//#endif

public class GLPlatformImpl implements GLPlatform {

    @Override
    public void enableStencil() {
        //#if FORGE==1
        Framebuffer framebuffer = UMinecraft.getMinecraft().getFramebuffer();
        //#else
        //$$ FramebufferHook framebuffer = ((FramebufferHook) UMinecraft.getMinecraft().getFramebuffer());
        //#endif
        if (!framebuffer.isStencilEnabled()) {
            framebuffer.enableStencil();
        }
    }

    @Override
    public float drawText(UMatrixStack matrixStack, String text, float x, float y, int color, boolean shadow) {
        //#if MC<=11202
        return UMinecraft.getFontRenderer().drawString(text, x, y, color, shadow);
        //#else
        //$$ if(shadow) {
        //$$    return UMinecraft.getFontRenderer().drawStringWithShadow(matrixStack.toMC(), text, x, y, color);
        //$$ } else return UMinecraft.getFontRenderer().drawString(matrixStack.toMC(), text, x, y, color);
        //#endif
    }

    @Override
    public int getStringWidth(String text) {
        return UMinecraft.getFontRenderer().getStringWidth(text);
    }
}
