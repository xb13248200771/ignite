/*
 * Copyright 2019 GridGain Systems, Inc. and Contributors.
 *
 * Licensed under the GridGain Community Edition License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gridgain.com/products/software/community-edition/gridgain-community-edition-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.testsuites;

import java.util.Collection;
import java.util.LinkedList;
import org.apache.ignite.spi.discovery.tcp.ipfinder.cloud.TcpDiscoveryCloudIpFinderSelfTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Ignite Cloud integration test.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TcpDiscoveryCloudIpFinderSelfTest.class})
public class IgniteCloudTestSuite {
    /**
     * <a href="http://jclouds.apache.org/guides/google/">Service Account email<a/> for GCE.
     * <a href="http://jclouds.apache.org/guides/aws/">Access Key ID</a> for Amazon.
     * <a href="http://jclouds.apache.org/guides/rackspace/">Username</a> for Rackspace.
     *
     * @return Access key.
     */
    public static String getAccessKey(String provider) {
        String key = System.getenv("test." + provider + ".access.key");

        assert key != null : "Environment variable 'test." + provider + ".access.key' is not set";

        return key;
    }

    /**
     * <a href="http://jclouds.apache.org/guides/google/">Path to pkcs12 file<a/> for GCE.
     * <a href="http://jclouds.apache.org/guides/aws/">Access Key</a> for Amazon.
     * <a href="http://jclouds.apache.org/guides/rackspace/">API key</a> for Rackspace.
     *
     * @return Secret key.
     */
    public static String getSecretKey(String provider) {
        String key = System.getenv("test." + provider + ".secret.key");

        assert key != null : "Environment variable 'test." + provider + ".secret.key' is not set";

        return key;
    }

    /**
     * Zones where VMs are located.
     *
     * @return Zones list or null.
     */
    public static Collection<String> getZones(String provider) {
        String zonesStr = System.getenv("test." + provider + ".zones.list");

        if (zonesStr == null)
            return null;

        String[] zonesArr = zonesStr.split(",");

        LinkedList<String> list = new LinkedList<>();

        for (String zone : zonesArr)
            list.add(zone.trim());

        return list;
    }

    /**
     * Regions where VMs are located.
     *
     * @return Zones list or null.
     */
    public static Collection<String> getRegions(String provider) {
        String regionStr = System.getenv("test." + provider + ".regions.list");

        if (regionStr == null)
            return null;

        String[] zonesArr = regionStr.split(",");

        LinkedList<String> list = new LinkedList<>();

        for (String zone : zonesArr)
            list.add(zone.trim());

        return list;
    }
}
