/*
 * This file is part of OneConfig.
 * OneConfig - Next Generation Config Library for Minecraft: Java Edition
 * Copyright (C) 2021, 2022 Polyfrost.
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

package cc.polyfrost.oneconfig.config.v1.options.type;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Represents a type of option.
 */
public interface OptionType {
    /**
     * The name of the option type.
     * @return The name of the option type.
     */
    String name();

    /**
     * The classes that are supported by this option type.
     * @return The classes that are supported by this option type.
     */
    List<Class<?>> supportedClasses();

    /**
     * Whether the given class is supported by this option type.
     * @param type The class to check.
     * @return Whether the given class is supported by this option type.
     */
    default boolean isSupportedClass(Class<?> type) {
        for (Class<?> supportedType : supportedClasses()) {
            if (supportedType.isAssignableFrom(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Whether the option type supports serialization.
     * @return Whether the option type supports serialization.
     */
    default boolean serializable() {
        return true;
    }

    /**
     * Get the name of the field provided.
     * @param field The field to get the name of.
     * @return The name of the field provided.
     */
    String getName(Field field);

    /**
     * Get the name of the method provided.
     * @param method The method to get the name of.
     * @return The name of the method provided.
     */
    String getName(Method method);

    /**
     * Get the description of the field provided.
     * @param field The field to get the description of.
     * @return The description of the field provided.
     */
    String getDescription(Field field);

    /**
     * Get the description of the method provided.
     * @param method The method to get the description of.
     * @return The description of the method provided.
     */
    String getDescription(Method method);

    /**
     * Get the category of the field provided.
     * @param field The field to get the category of.
     * @return The category of the field provided.
     */
    String getCategory(Field field);

    /**
     * Get the category of the method provided.
     * @param method The method to get the category of.
     * @return The category of the method provided.
     */
    String getCategory(Method method);

    /**
     * Get the subcategory of the field provided.
     * @param field The field to get the subcategory of.
     * @return The subcategory of the field provided.
     */
    String getSubcategory(Field field);

    /**
     * Get the subcategory of the method provided.
     * @param method The method to get the subcategory of.
     * @return The subcategory of the method provided.
     */
    String getSubcategory(Method method);

    /**
     * Get the search tags of the field provided.
     * @param field The field to get the search tags of.
     * @return The search tags of the field provided.
     */
    String[] getTags(Field field);

    /**
     * Get the search tags of the method provided.
     * @param method The method to get the search tags of.
     * @return The search tags of the method provided.
     */
    String[] getTags(Method method);
}
