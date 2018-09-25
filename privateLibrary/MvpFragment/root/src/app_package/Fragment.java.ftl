package ${packageName};

public class ${className}Fragment extends BaseFragment implements
        ${className}MvpView {

    private static final String TAG = "${className}Fragment";

    @Inject
    ${className}MvpPresenter<${className}MvpView> mPresenter;

    public static ${className}Fragment newInstance() {
        Bundle args = new Bundle();
        ${className}Fragment fragment = new ${className}Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_${className}, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
            m${className}Adapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
    
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}

