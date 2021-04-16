package com.myproject.moods.Util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Component
public class JedisClusterUtil {
        Set<HostAndPort> nodes =new HashSet<>();
        JedisCluster jedisCluster;

    public JedisClusterUtil() {
        nodes.add(new  HostAndPort("47.98.192.167",7001));
        nodes.add(new  HostAndPort("47.98.192.167",7002) );
        nodes.add(new  HostAndPort("47.98.192.167",7003) );
        nodes.add(new  HostAndPort("47.98.192.167",7004) );
        nodes.add(new  HostAndPort("47.98.192.167",7005) );
        nodes.add(new  HostAndPort("47.98.192.167",7006) );
        jedisCluster= new JedisCluster(nodes);
    }
    public JedisClusterUtil(String[] ip,int [] port) {
        nodes.add(new  HostAndPort(ip[0],port[0]));
        nodes.add(new  HostAndPort(ip[1],port[1]));
        nodes.add(new  HostAndPort(ip[2],port[2]));
        nodes.add(new  HostAndPort(ip[3],port[3]));
        nodes.add(new  HostAndPort(ip[4],port[4]));
        nodes.add(new  HostAndPort(ip[5],port[5]));

        jedisCluster= new JedisCluster(nodes);
    }

    public Set<HostAndPort> getNodes() {
        return nodes;
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }
}
