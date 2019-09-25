package com.logfuze.iot.powerdata.repository;
import com.datastax.driver.core.Session;

/**
 * Repository to handle the Cassandra schema.
 *
 */
public class KeyspaceRepository {
	private static final String keyspaceName = "logfuze_ks_powerenergy";
	private static final String replicatioonStrategy = "SimpleStrategy"; // this can be a NetworkTopologyStrategy if we run a multiple data center in a cluster.
	private static int numberOfReplicas = 1; // this can increased based on our needs.
	
	private Session session;

    public KeyspaceRepository(Session session) {
        this.session = session;
    }

    /**
     * Method used to create any keyspace - schema.
     * 
     * @param schemaName the name of the schema.
     * @param replicatioonStrategy the replication strategy.
     * @param numberOfReplicas the number of replicas.
     * 
     */
    public void createKeyspace() {
        StringBuilder sb = new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ").append(keyspaceName).append(" WITH replication = {").append("'class':'").append(replicatioonStrategy).append("','replication_factor':").append(numberOfReplicas).append("};");

        final String query = sb.toString();

        session.execute(query);
    }

    public void useKeyspace() {
        session.execute("USE " + keyspaceName);
    }

    /** dont need to use it.
     * Method used to delete the specified schema.
     * It results in the immediate, irreversable removal of the keyspace, including all tables and data contained in the keyspace.
     * 
     * @param schemaName the name of the keyspace to delete.
     */
    public void deleteKeyspace() {
        StringBuilder sb = new StringBuilder("DROP KEYSPACE ").append(keyspaceName);

        final String query = sb.toString();

        session.execute(query);
    }
}
