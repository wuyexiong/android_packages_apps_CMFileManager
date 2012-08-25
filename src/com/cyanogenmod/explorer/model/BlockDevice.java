/*
 * Copyright (C) 2012 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.explorer.model;

import java.util.Date;

/**
 * A class that represents a block device.
 *
 * {@link "http://en.wikipedia.org/wiki/Block_special_file#Block_devices"}
 */
public class BlockDevice extends SystemFile {

    private static final long serialVersionUID = -4090113368100371854L;

    /**
     * The unix identifier of the object.
     * @hide
     */
    public static final char UNIX_ID = 'b';

    /**
     * Constructor of <code>BlockDevice</code>.
     *
     * @param name The name of the object
     * @param parent The parent folder of the object
     * @param user The user proprietary of the object
     * @param group The group proprietary of the object
     * @param permissions The permissions of the object
     * @param lastModifiedTime The last time that the object was modified
     */
    public BlockDevice(String name, String parent, User user, Group group, Permissions permissions,
            Date lastModifiedTime) {
        super(name, parent, user, group, permissions, lastModifiedTime, 0L);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char getUnixIdentifier() {
        return UNIX_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "BlockDevice [type=" + super.toString() + "]";  //$NON-NLS-1$//$NON-NLS-2$
    }

}
