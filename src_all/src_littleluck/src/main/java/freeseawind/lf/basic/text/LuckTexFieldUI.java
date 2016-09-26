package freeseawind.lf.basic.text;

import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;

import freeseawind.lf.border.LuckBorderField;
import freeseawind.lf.event.LuckBorderFocusHandle;

/**
 * <p>
 * TexFieldUI实现类，使用圆角焦点边框作为默认边框。
 * </p>
 *
 * <p>
 * TexFieldUI implementation class, rounded corners as the default focus frame border.
 * </p>
 *
 * @author freeseawind@github
 * @version 1.0
 *
 */
public class LuckTexFieldUI extends BasicTextFieldUI implements LuckBorderField
{
    protected LuckBorderFocusHandle handle;
    private RectangularShape borderShape;
    private boolean isFocusGained;

    public static ComponentUI createUI(JComponent c)
    {
        return new LuckTexFieldUI();
    }

    public void installUI(JComponent c)
    {
        super.installUI(c);

        borderShape = new RoundRectangle2D.Float(0, 0, 0, 0, 8, 8);

        handle = createFocusHandle();

        c.addMouseListener(handle);

        c.addFocusListener(handle);
    }

    @Override
    public void uninstallUI(JComponent c)
    {
        super.uninstallUI(c);

        c.removeMouseListener(handle);

        c.removeFocusListener(handle);

        handle = null;
    }

    /**
     * <p>创建边框焦点监听器。</p>
     *
     * <p>Create the border focus listener.</p>
     *
     * @return <code>LuckBorderFocusHandle</code>
     */
    protected LuckBorderFocusHandle createFocusHandle()
    {
        return new LuckFocusHandler();
    }

    public void setFocusGained(boolean isFoucusGaind)
    {
        this.isFocusGained = isFoucusGaind;
    }

    public boolean isFocusGaind()
    {
        return isFocusGained;
    }

    public RectangularShape getBorderShape()
    {
        return borderShape;
    }

    public void setBorderShape(RectangularShape shape)
    {
        this.borderShape = shape;
    }

    public class LuckFocusHandler extends LuckBorderFocusHandle
    {
        @Override
        public JComponent getComponent()
        {
            return LuckTexFieldUI.this.getComponent();
        }

        @Override
        public LuckBorderField getBorderField()
        {
            return LuckTexFieldUI.this;
        }
    }
}
