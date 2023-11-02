package org.example.minicluster;

import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.protocol.RaftGroup;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.statemachine.impl.BaseStateMachine;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

// Referring IoTDB and playing with it to set up and play consensuss using Ratis
//

public class MiniCluster {


    public static void main(String[] args) throws IOException {
        MiniServer server = new MiniServer();
        server.start();
        server.stop();

    }


    public static class MiniServer {
      //  private final RaftServer server;

        public MiniServer() throws IOException {
        //    final RaftProperties properties = new RaftProperties();
            String groupIdStr = "29e67930-86b7-4037-a52a-eefcf28dbfde";
            UUID groupId = UUID.fromString(groupIdStr);

            List<RaftPeer> peers = new LinkedList<>();
            peers.add(RaftPeer.newBuilder().setId("n0").build());
            peers.add(RaftPeer.newBuilder().setId("n1").build());
            final RaftGroup raftGroup = RaftGroup.valueOf(RaftGroupId.valueOf(groupId), peers);
            System.out.println(raftGroup);
       //     final RaftPeer raftPeer = RaftPeer.newBuilder().build();
//            this.server = RaftServer.newBuilder().
//                                setGroup(raftGroup).
//                                setServerId(raftPeer.getId()).
//                                 setProperties(properties).
//                                 setStateMachine(new SampleStateMachine()).
//                                 build();
        }

        public void start() throws IOException {
            // server.start();
        }


        public void stop() throws IOException {
           // server.close();
        }
    }


}
