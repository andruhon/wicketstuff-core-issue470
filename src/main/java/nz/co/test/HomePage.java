package nz.co.test;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		final Label result;
		add(result = new Label("result", new PropertyModel<>(this, "result")));
		result.setOutputMarkupId(true);

		final ModalWindow modal2;
		add(modal2 = new ModalWindow("modal2"));

		modal2.setContent(new ModalPanel1(modal2.getContentId()));
		modal2.setTitle("Modal window\n'panel\" content.");
		modal2.setCookieName("modal-2");

		modal2.setCloseButtonCallback(target -> {
			setResult("Modal window 2 - close button");
			return true;
		});

		modal2.setWindowClosedCallback(target -> target.add(result));

		add(new AjaxLink<Void>("showModal2")
		{
			@Override
			public void onClick(AjaxRequestTarget target)
			{
				modal2.show(target);
			}
		});

    }

	/**
	 * @return the result
	 */
	public String getResult()
	{
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result)
	{
		this.result = result;
	}

	private String result;
}
