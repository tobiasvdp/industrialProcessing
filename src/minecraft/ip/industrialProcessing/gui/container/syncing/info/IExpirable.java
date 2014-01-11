package ip.industrialProcessing.gui.container.syncing.info;

public interface IExpirable {
    public boolean tick();
    public boolean isExpired();
}
