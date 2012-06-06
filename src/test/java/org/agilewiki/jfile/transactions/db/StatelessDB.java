package org.agilewiki.jfile.transactions.db;

import org.agilewiki.jactor.Mailbox;
import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;

public class StatelessDB extends DB {
    @Override
    protected void processRequest(Object request, RP rp) throws Exception {
        rp.processResponse(null);
    }
}
