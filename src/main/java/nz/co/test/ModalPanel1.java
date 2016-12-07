package nz.co.test;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;
import org.wicketstuff.select2.StringTextChoiceProvider;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ModalPanel1 extends Panel
{

    private String letter = "A";

    private final List<String> choices = Arrays.asList("a", "b", "c", "d");

    private final StringTextChoiceProvider choiceProvider = new StringTextChoiceProvider() {
        @Override
        public void query(String s, int i, Response<String> response) {
            response.setResults(choices);
        }
    };

    public ModalPanel1(String id)
    {
        super(id);

        add(new Select2Choice<>("letters", new PropertyModel<String>(this, "letter"), choiceProvider));
    }



}