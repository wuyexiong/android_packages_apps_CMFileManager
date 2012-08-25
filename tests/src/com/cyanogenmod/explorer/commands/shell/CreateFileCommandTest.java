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

package com.cyanogenmod.explorer.commands.shell;

import com.cyanogenmod.explorer.console.ExecutionException;
import com.cyanogenmod.explorer.util.CommandHelper;

/**
 * A class for testing the {@link CreateFileCommand} command.
 *
 * @see CreateFileCommand
 */
public class CreateFileCommandTest extends AbstractConsoleTest {

    private static final String PATH_NEWFILE_OK = "/mnt/sdcard/newtest.txt"; //$NON-NLS-1$
    private static final String PATH_NEWFILE_ERROR = "/mnt/sdcard121212/newtest.txt"; //$NON-NLS-1$

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRootConsoleNeeded() {
        return false;
    }

    /**
     * Method that performs a test to create a new file.
     *
     * @throws Exception If test failed
     */
    public void testCreateFileOk() throws Exception {
        try {
            boolean ret = CommandHelper.createFile(getContext(), PATH_NEWFILE_OK, getConsole());
            assertTrue("response==false", ret); //$NON-NLS-1$
        } finally {
            try {
                CommandHelper.deleteFile(getContext(), PATH_NEWFILE_OK, getConsole());
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

    /**
     * Method that performs a test to create a new invalid file.
     *
     * @throws Exception If test failed
     */
    public void testCreateFileFail() throws Exception {
        try {
            CommandHelper.createFile(getContext(), PATH_NEWFILE_ERROR, getConsole());
            assertTrue("exit code==0", false); //$NON-NLS-1$
        } catch (ExecutionException error) {
          //This command must failed. exit code !=0
        }
    }


}
