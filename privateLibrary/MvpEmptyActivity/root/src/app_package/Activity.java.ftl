package ${packageName};

public class ${className}Activity extends BaseActivity implements ${className}MvpView {

    @Inject
    ${className}MvpPresenter<${className}MvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ${className}Activity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xxx);

        getActivityComponent().inject(this);

        mPresenter.onAttach(${className}Activity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        Activity${className}Binding binding = DataBindingUtil.setContentView(this, R.layout.xxx);
    }
}
